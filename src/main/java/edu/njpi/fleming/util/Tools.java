package edu.njpi.fleming.util;

import com.google.gson.Gson;
import edu.njpi.fleming.action.form.Message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Tools {

    /**
     * 发起http请求并获取结果
     *
     * @param requestUrl 请求地址
     * @param requestMethod 请求方式（GET、POST）
     * @return Message,格式和服务器端相同
     */
    public static Message httpRequest(String requestUrl, String requestMethod) {

        Message message = null;
        StringBuffer buffer = new StringBuffer();
        InputStream inputStream=null;

        try {

            URL url = new URL(requestUrl);
            HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();
            httpUrlConn.setDoInput(true);
            httpUrlConn.setUseCaches(false);

            // 设置请求方式（GET/POST）
            httpUrlConn.setRequestMethod(requestMethod);
            if ("GET".equalsIgnoreCase(requestMethod)){
                httpUrlConn.connect();
            }

            //将返回的输入流转换成字符串
            inputStream = httpUrlConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String str;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();

            // 释放资源
            inputStream.close();
            inputStream = null;
            httpUrlConn.disconnect();

            Gson gson = new Gson();
            message = gson.fromJson(buffer.toString(), Message.class);
        } catch (ConnectException ce) {
            ce.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if(inputStream!=null){
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return message;
    }

}
