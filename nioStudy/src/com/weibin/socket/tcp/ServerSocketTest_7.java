package com.weibin.socket.tcp;
import	java.util.Date;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/4
 **/
public class ServerSocketTest_7 {

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(8088);
        Socket accept = socket.accept();
        InputStream in = accept.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line;
        while ((line = reader.readLine()) != null){
            System.out.println("服务端接受到数据时间为：" + new Date().toLocaleString() + "---->" + line);
        }
        reader.close();
        in.close();
        accept.close();
        socket.close();

    }

}
