package com.weibin.socket.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/4
 **/
public class ServerSocketTest_2 {

    public static void main(String[] args) throws IOException {
        byte[] bytes = new byte[1024];
        ServerSocket socket = new ServerSocket(8088);
        System.out.println("accept 阻塞开始 ： " + new Date().toLocaleString());
        Socket accept = socket.accept();
        System.out.println("accept 阻塞结束 ： " + new Date().toLocaleString());
        InputStream stream = accept.getInputStream();
        System.out.println("read 阻塞开始 ： " + new Date().toLocaleString());
        int readLength = stream.read(bytes);
        System.out.println("read 阻塞结束： " + new Date().toLocaleString());
        stream.close();
        accept.close();
        socket.close();


    }

}
