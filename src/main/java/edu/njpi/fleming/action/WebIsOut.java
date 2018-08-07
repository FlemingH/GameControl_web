package edu.njpi.fleming.action;

import edu.njpi.fleming.server.ControlServer;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class WebIsOut extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) {

        String username = request.getParameter("username");
        Map<String, String> webOnlineMap = ControlServer.getWebOnlineMap();
        webOnlineMap.remove(username);
        System.out.println(username+"退出web");

    }

}
