package edu.njpi.fleming.webAction;

import com.google.gson.Gson;
import edu.njpi.fleming.action.form.Message;
import edu.njpi.fleming.util.Tools;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;


/**
 * 验证登录
 * 不给重复登陆
 */
public class ForwardMain extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Gson gson = new Gson();

        Message message = Tools.httpRequest("http://118.25.180.193:8081/LoginAction?username="+username+"&password="+password, "GET");

        if("fail".equals(message.getAjaxState())){
            String json = gson.toJson(message);
            response.setContentType("application/json; charset=utf-8");
            response.setCharacterEncoding("UTF-8");
            OutputStream out = response.getOutputStream();
            out.write(json.getBytes("UTF-8"));
            out.flush();
        } else {

            Message isWebOnlineMessage = Tools.httpRequest("http://127.0.0.1:8090/CheckWebIsOnline?username="+username, "GET");

            if("ok".equals(isWebOnlineMessage.getAjaxState())){
                message = new Message("WebIsOnline");
                String json = gson.toJson(message);
                response.setContentType("application/json; charset=utf-8");
                response.setCharacterEncoding("UTF-8");
                OutputStream out = response.getOutputStream();
                out.write(json.getBytes("UTF-8"));
                out.flush();
            } else {
                message = new Message("ok");
                String json = gson.toJson(message);
                response.setContentType("application/json; charset=utf-8");
                response.setCharacterEncoding("UTF-8");
                OutputStream out = response.getOutputStream();
                out.write(json.getBytes("UTF-8"));
                out.flush();
            }
        }
    }
}
