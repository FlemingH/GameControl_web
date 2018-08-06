package edu.njpi.fleming.socket;

import edu.njpi.fleming.server.ControlServer;

import javax.websocket.OnClose;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.Map;

/**
 * websocket的转发中心
 */
@ServerEndpoint(value = "/SocketHandle/{connType}/{username}")
public class SocketHandle {

    //获得三个map用来存储获取发送地址
    private static Map<String, Session> webOnlineSocketMap = ControlServer.getWebOnlineSocketMap();
    private static Map<String, Session> appOnlineSocketMap = ControlServer.getAppOnlineSocketMap();
    private static Map<String, Session> controlSocketWebMap = ControlServer.getControlSocketWebMap();

    @OnOpen
    public void onOpen(@PathParam(value = "connType") String connType, @PathParam(value = "username")
                       String username, Session session){
        //app建立连接
        if ("app".equals(connType)){

            System.out.println(username+"-app-建立socket连接");
            appOnlineSocketMap.put(username,session);

        //web建立连接
        } else if ("web".equals(connType)){

            System.out.println(username+"-web-建立socket连接");
            webOnlineSocketMap.put(username,session);

        //control建立连接
        } else if ("control".equals(connType)){

            System.out.println(username+"-control-建立socket连接");
            controlSocketWebMap.put(username,session);

        }
    }

    @OnClose
    public void onClose(@PathParam(value = "connType") String connType,
                        @PathParam(value = "username") String username){
        //app断开连接
        if ("app".equals(connType)){

            System.out.println(username+"-app-断开socket连接");
            appOnlineSocketMap.remove(username);

        //web断开连接
        } else if ("web".equals(connType)){

            System.out.println(username+"-web-断开socket连接");
            webOnlineSocketMap.remove(username);

        //control断开连接
        } else if ("control".equals(connType)){

            System.out.println(username+"-control-断开socket连接");
            controlSocketWebMap.remove(username);

        }
    }



}
