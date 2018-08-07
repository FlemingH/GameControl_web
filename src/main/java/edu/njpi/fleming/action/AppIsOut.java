package edu.njpi.fleming.action;

import edu.njpi.fleming.server.ControlServer;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class AppIsOut extends HttpServlet {

    //把App信息从map里移除
    public void doGet(HttpServletRequest request, HttpServletResponse response) {

        String username = request.getParameter("username");
        Map<String, String> appOnlineMap = ControlServer.getAppOnlineMap();
        appOnlineMap.remove(username);
        System.out.println(username+"退出app");

    }

}
