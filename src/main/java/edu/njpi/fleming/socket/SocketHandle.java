package edu.njpi.fleming.socket;

import com.google.gson.Gson;
import edu.njpi.fleming.action.form.SocketMessage;
import edu.njpi.fleming.server.ControlServer;

import javax.websocket.*;
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

        Gson gson = new Gson();
        SocketMessage sendMessage = new SocketMessage();

        //app建立连接-------------------------------------------------------------------------
        if ("app".equals(connType)){

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

        //web建立连接-------------------------------------------------------------------------
        } else if ("web".equals(connType)){

            System.out.println(username+"-web-建立socket连接");
            webOnlineSocketMap.put(username,session);

            for (Map.Entry<String, Session> entry : appOnlineSocketMap.entrySet()){
                if(username.equals(entry.getKey())){
                    sendMessage.setMessageType("webIsOnline");
                    sendMessage.setData("");
                    entry.getValue().getAsyncRemote().sendText(gson.toJson(sendMessage));
                    break;
                }
            }

        //control建立连接---------------------------------------------------------------------
        } else if ("control".equals(connType)){

            System.out.println(username+"-control-建立socket连接");
            controlSocketWebMap.put(username,session);

        }
    }

    @OnClose
    public void onClose(@PathParam(value = "connType") String connType,
                        @PathParam(value = "username") String username){

        Gson gson = new Gson();
        SocketMessage sendMessage = new SocketMessage();

        //app断开连接-------------------------------------------------------------------------
        if ("app".equals(connType)){

            //处理同AppIsOffline
            for(Map.Entry<String, Session> entry : webOnlineSocketMap.entrySet()){
                if(username.equals(entry.getKey())){
                    sendMessage.setMessageType("AppIsOffline");
                    sendMessage.setData("");
                    entry.getValue().getAsyncRemote().sendText(gson.toJson(sendMessage));
                    break;
                }
            }

            System.out.println(username+"-app-断开socket连接");
            appOnlineSocketMap.remove(username);

        //web断开连接-------------------------------------------------------------------------
        } else if ("web".equals(connType)){

            //处理同webIsOffline
            for (Map.Entry<String, Session> entry : appOnlineSocketMap.entrySet()){
                if(username.equals(entry.getKey())){
                    sendMessage.setMessageType("webIsOffline");
                    sendMessage.setData("");
                    entry.getValue().getAsyncRemote().sendText(gson.toJson(sendMessage));
                    break;
                }
            }

            System.out.println(username+"-web-断开socket连接");
            webOnlineSocketMap.remove(username);

        //control断开连接---------------------------------------------------------------------
        } else if ("control".equals(connType)){

            System.out.println(username+"-control-断开socket连接");
            controlSocketWebMap.remove(username);

        }
    }

    @OnMessage
    public void onMessage(String message, @PathParam(value = "username") String username){

        Gson gson = new Gson();
        SocketMessage socketMessage = gson.fromJson(message, SocketMessage.class);
        String messageType = socketMessage.getMessageType();

        SocketMessage sendMessage = null;

        //前进键按下
        if("wButtonDown".equals(messageType)){
            for(Map.Entry<String, Session> entry : webOnlineSocketMap.entrySet()){
                if(username.equals(entry.getKey())){
                    sendMessage.setMessageType("wButtonDown");
                    sendMessage.setData("");
                    entry.getValue().getAsyncRemote().sendText(gson.toJson(sendMessage));
                    break;
                }
            }
        }

        //前进键松开
        if("wButtonUp".equals(messageType)){
            for(Map.Entry<String, Session> entry : webOnlineSocketMap.entrySet()){
                if(username.equals(entry.getKey())){
                    sendMessage.setMessageType("wButtonUp");
                    sendMessage.setData("");
                    entry.getValue().getAsyncRemote().sendText(gson.toJson(sendMessage));
                    break;
                }
            }
        }

        //后退键按下
        if("sButtonDown".equals(messageType)){
            for(Map.Entry<String, Session> entry : webOnlineSocketMap.entrySet()){
                if(username.equals(entry.getKey())){
                    sendMessage.setMessageType("sButtonDown");
                    sendMessage.setData("");
                    entry.getValue().getAsyncRemote().sendText(gson.toJson(sendMessage));
                    break;
                }
            }
        }

        //后退键松开
        if("sButtonUp".equals(messageType)){
            for(Map.Entry<String, Session> entry : webOnlineSocketMap.entrySet()){
                if(username.equals(entry.getKey())){
                    sendMessage.setMessageType("sButtonUp");
                    sendMessage.setData("");
                    entry.getValue().getAsyncRemote().sendText(gson.toJson(sendMessage));
                    break;
                }
            }
        }

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

    }

    @OnError
    public void onError(Throwable error) {
        error.printStackTrace();
    }

}
