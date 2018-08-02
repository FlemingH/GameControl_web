package edu.njpi.fleming.action;

import com.google.gson.Gson;
import edu.njpi.fleming.action.form.Message;
import edu.njpi.fleming.server.ControlServer;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

public class CheckWebIsOnline extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String username = request.getParameter("username");
        ServletContext webApplication = ControlServer.getWebApplication();

        Gson gson = new Gson();
        Message message;

        if(webApplication.getAttribute(username) != null) {
            message = new Message("ok");
            String json = gson.toJson(message);
            response.setContentType("application/json; charset=utf-8");
            response.setCharacterEncoding("UTF-8");
            OutputStream out = response.getOutputStream();
            out.write(json.getBytes("UTF-8"));
            out.flush();
        } else {
            message = new Message("fail");
            String json = gson.toJson(message);
            response.setContentType("application/json; charset=utf-8");
            response.setCharacterEncoding("UTF-8");
            OutputStream out = response.getOutputStream();
            out.write(json.getBytes("UTF-8"));
            out.flush();
        }

    }

}
