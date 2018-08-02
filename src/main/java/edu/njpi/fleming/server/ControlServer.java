package edu.njpi.fleming.server;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.websocket.Session;
import java.util.HashMap;
import java.util.Map;

/**
 * 控制服务器
 * 在工程发布的同时创建：OnlineSocketMap、ControlSocketWebMap、AppApplication、WebApplication
 * 用于保存username、Session
 */
public class ControlServer implements ServletContextListener {

    private static ServletContext AppApplication;
    private static ServletContext WebApplication;
    private static Map<String, Session> OnlineSocketMap;
    private static Map<String, Session> ControlSocketWebMap;

    public static ServletContext getAppApplication() {
        return AppApplication;
    }

    public static ServletContext getWebApplication() {
        return WebApplication;
    }

    public static Map<String, Session> getOnlineSocketMap() {
        return OnlineSocketMap;
    }

    public static Map<String, Session> getControlSocketWebMap() {
        return ControlSocketWebMap;
    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        AppApplication = servletContextEvent.getServletContext();
        WebApplication = servletContextEvent.getServletContext();
        OnlineSocketMap = new HashMap<>(16);
        ControlSocketWebMap = new HashMap<>(16);

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

        AppApplication = null;
        WebApplication = null;
        OnlineSocketMap = null;
        ControlSocketWebMap = null;

    }

}
