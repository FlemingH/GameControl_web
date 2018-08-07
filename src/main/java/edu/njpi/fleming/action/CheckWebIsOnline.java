package edu.njpi.fleming.action;

import com.google.gson.Gson;
import edu.njpi.fleming.action.form.Message;
import edu.njpi.fleming.server.ControlServer;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

public class CheckWebIsOnline extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String username = request.getParameter("username");
        Map<String, String> webOnlineMap = ControlServer.getWebOnlineMap();

        Gson gson = new Gson();
        Message message;

        if(!"".equals(webOnlineMap.get(username))) {
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
