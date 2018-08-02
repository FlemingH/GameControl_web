package edu.njpi.fleming.action;

import edu.njpi.fleming.server.ControlServer;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AppIsOut extends HttpServlet {

    //把App信息从map里移除
    public void doGet(HttpServletRequest request, HttpServletResponse response) {

        String username = request.getParameter("username");
        ServletContext appApplication = ControlServer.getAppApplication();
        appApplication.removeAttribute(username);
        System.out.println(username+"退出app");

    }

}
