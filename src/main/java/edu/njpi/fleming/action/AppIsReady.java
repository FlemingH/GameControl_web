package edu.njpi.fleming.action;

import edu.njpi.fleming.server.ControlServer;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AppIsReady extends HttpServlet {

    //新增App信息到map里
    public void doGet(HttpServletRequest request, HttpServletResponse response) {

        String username = request.getParameter("username");
        ServletContext appApplication = ControlServer.getAppApplication();
        appApplication.setAttribute(username, request.getSession());
        System.out.println(username+"登录app");

    }

}
