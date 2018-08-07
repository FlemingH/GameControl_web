package edu.njpi.fleming.server;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.websocket.Session;
import java.util.HashMap;
import java.util.Map;

/**
 * 控制服务器
 * 在工程发布的同时创建：OnlineSocketMap、ControlSocketWebMap、AppApplication、WebApplication
 * 用于保存username、Session
 */
@WebListener
public class ControlServer implements ServletContextListener {

    private static Map<String, String> AppOnlineMap;
    private static Map<String, String> WebOnlineMap;
    //向Web发送信息的地址
    private static Map<String, Session> WebOnlineSocketMap;
    //向App发送信息的地址
    private static Map<String, Session> AppOnlineSocketMap;
    //用于存储app控制socket的发送源
    private static Map<String, Session> ControlSocketWebMap;

    public static Map<String, String> getAppOnlineMap() { return AppOnlineMap; }

    public static Map<String, String> getWebOnlineMap() { return WebOnlineMap; }

    public static Map<String, Session> getWebOnlineSocketMap() {
        return WebOnlineSocketMap;
    }

    public static Map<String, Session> getAppOnlineSocketMap() {
        return AppOnlineSocketMap;
    }

    public static Map<String, Session> getControlSocketWebMap() {
        return ControlSocketWebMap;
    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        AppOnlineMap = new HashMap<>(16);
        WebOnlineMap = new HashMap<>(16);
        WebOnlineSocketMap = new HashMap<>(16);
        AppOnlineSocketMap = new HashMap<>(16);
        ControlSocketWebMap = new HashMap<>(16);

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

        AppOnlineMap = null;
        WebOnlineMap = null;
        WebOnlineSocketMap = null;
        AppOnlineSocketMap = null;
        ControlSocketWebMap = null;

    }

}
