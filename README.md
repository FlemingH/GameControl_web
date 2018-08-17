# GameControl_web

## 大纲 Synopsis
android游戏控制器的服务器：用于处理客户端上下线、接收app的控制信息，转发给web客户端。<br>
android Game-Control's server：To handle client's online and offline also receive the message from the app in order to forward to the web client。

## 创作动机 Motivation
在你想用PC游玩赛车类型游戏的时候，有没有对键盘操作感到厌倦？这个软件用手机代替你的键盘完成转向和加速操作，玩PC的赛车游戏现在也可以有在手机端一样的体验！<br>
Hava you ever get tired of using keyboard when you play racing game on your PC? This software replace your keyboard with your phone 
to do turning and acceleration, you can possess the feeling of moblie game when you play the PC's racing game.

## 如何安装 Installation 
这个版本能用，但是并不是最好的解决方案，想要在你的电脑上运行，你的PC上需要一个可以发布这个工程的服务器，比如tomcat...你在玩游戏前使用8090端口发布，
登陆手机端登陆再打开web客户端登陆，等一切就绪的时候你就可以操控了！<br>
This version works, but it's not the best solution. To run on your computer, you need a server on your PC that can publish the project, 
such as tomcat... 
you use port 8090 publish it before you play the game.
Then login you moblie app and open the web client to login. When you are ready, you can control it!

## 代码示例 Code Example 

在工程发布的时候创建5个map用于存储用户名和对应信息的键值对。<br>
When the project is published, create 5 Map for storing username and information.
```java
 @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        AppOnlineMap = new HashMap<>(16);
        WebOnlineMap = new HashMap<>(16);
        WebOnlineSocketMap = new HashMap<>(16);
        AppOnlineSocketMap = new HashMap<>(16);
        ControlSocketWebMap = new HashMap<>(16);

    }
```

---------------------------

通过http请求来注册登录信息和判断是否登陆，如下面用于判断app是否在线<br>
Register login information and determine whether to login or not through HTTP request,  For example, To determine whether app is online.
```java
public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String username = request.getParameter("username");
        Map<String, String> appOnlineMap = ControlServer.getAppOnlineMap();

        Gson gson = new Gson();
        Message message;

        if(appOnlineMap.containsKey(username)){
            message = new Message("ok");
            String json = gson.toJson(message);
            response.setContentType("application/json; charset=utf-8");
            response.setCharacterEncoding("UTF-8");
            OutputStream out = response.getOutputStream();
            out.write(json.getBytes("UTF-8"));
            out.flush();
        } else {
            message = new Message("fail");
            String json = gson.toJson(message);
            response.setContentType("application/json; charset=utf-8");
            response.setCharacterEncoding("UTF-8");
            OutputStream out = response.getOutputStream();
            out.write(json.getBytes("UTF-8"));
            out.flush();
        }

}
```

---------------------------

web端和app端都用这样的方式连接websocket服务器<br>
Both web and app connect websocket servers in this way.
```java
@ServerEndpoint(value = "/SocketHandle/{connType}/{username}")
```

---------------------------

在app/web建立websocket连接的时候发送登录信息给web/app，下线的时候同理。<br>
When app/web establishes websocket connection, send login information to web/app. Same way when disconnection.
```java
//app建立连接-------------------------------------------------------------------------
if ("app".equals(connType)) {
    System.out.println(username+"-app-建立socket连接");
    appOnlineSocketMap.put(username,session);
    for(Map.Entry<String, Session> entry : webOnlineSocketMap.entrySet()){
        if(username.equals(entry.getKey())){
            sendMessage.setMessageType("AppIsOnline");
            sendMessage.setData("");
            entry.getValue().getAsyncRemote().sendText(gson.toJson(sendMessage));
            break;
        }        
    }
} 
```

---------------------------

用 java Robot 控制键盘，例如服务器接收到app发来L7信息时，让web端通过ajax访问jsp，jsp内用线程操控键盘，
由于工程在本地也有发布，所以本地的键盘就被控制了。<br>
Use Java Robot to control the keyboard. For example, when the server receives the L7 information from app, let the web client access the JSP through ajax, and the JSP controls the keyboard by thread. Because the project is also published locally, the local keyboard is controlled.

```java
//方向改变
if("dChange".equals(messageType)){
    for(Map.Entry<String, Session> entry : webOnlineSocketMap.entrySet()){
         if(username.equals(entry.getKey())){
              sendMessage.setMessageType("dChange");
              sendMessage.setData(socketMessage.getData());
              entry.getValue().getAsyncRemote().sendText(gson.toJson(sendMessage));
              break;
          }           
    }
}
```
---------------------------
```javascript
case -7:
    $.ajax({
    url:'http://127.0.0.1:8090/jsp/L7.jsp',
    type:'GET',
    dataType:'jsp'
    });                       
break;
```
---------------------------
```jsp
<%@ page import="edu.njpi.fleming.thread.StopDThread" %>
<%@ page import="edu.njpi.fleming.thread.L7" %>
<html>
<body>
    <%
        StopDThread.stopAllDThread();
        new L7().start();
    %>
</body>
</html>
```
---------------------------
```java
@Override
    public void run() {

        isL7Stop = false;
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        while (!isL7Stop) {
            robot.setAutoDelay(1500);
            robot.keyPress(KeyEvent.VK_LEFT);
            robot.setAutoDelay(500);
            robot.keyRelease(KeyEvent.VK_LEFT);
        }

}
```

---------------------------

## 参与者介绍 Contributors 
[Fleming](https://github.com/FlemingH)-Initial work

## License
[MIT](http://opensource.org/licenses/MIT)

Copyright (c) 2018-present, Limi (Fleming) Fei
