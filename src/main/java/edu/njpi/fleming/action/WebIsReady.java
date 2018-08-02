package edu.njpi.fleming.action;

import edu.njpi.fleming.server.ControlServer;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WebIsReady extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) {

        String username = request.getParameter("username");
        ServletContext webApplication = ControlServer.getWebApplication();
        webApplication.setAttribute(username,request.getSession());
        System.out.println(username+"登录web");

    }

}
