package edu.njpi.fleming.action;

import edu.njpi.fleming.server.ControlServer;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class AppIsReady extends HttpServlet {

    //新增App信息到map里
    public void doGet(HttpServletRequest request, HttpServletResponse response) {

        String username = request.getParameter("username");
        Map<String, String> appOnlineMap = ControlServer.getAppOnlineMap();
        appOnlineMap.put(username,username);
        System.out.println(username+"登录app");

    }

}
