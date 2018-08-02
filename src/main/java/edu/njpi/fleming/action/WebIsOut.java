package edu.njpi.fleming.action;

import edu.njpi.fleming.server.ControlServer;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WebIsOut extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) {

        String username = request.getParameter("username");
        ServletContext webApplication = ControlServer.getWebApplication();
        webApplication.removeAttribute(username);
        System.out.println(username+"退出web");

    }

}
