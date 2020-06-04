package com.weibin.socket.tcp;
import java.io.*;

import java.io.BufferedReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/2
 **/
public class WebServerSocketTest {

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(8090);
        Socket accept = socket.accept();
        InputStream in = accept.getInputStream();
        InputStreamReader reader1 = new InputStreamReader(in);
        BufferedReader reader = new BufferedReader(reader1);
        String str = "";
        while ((str = reader.readLine()).length() != 0){
            System.out.println(str);
        }
        System.out.println("循环结束！！！");
        OutputStream out = accept.getOutputStream();
        out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
        out.write(("<html>" +
                    "<body>" +
                        "<a href='http://www.baidu.com' height = '400px'> welcome! " +
                        "</a>" +
                    "</body>" +
                  "</html>").getBytes());
        out.flush();
        in.close();
        out.close();
        accept.close();
        socket.close();
    }

}
