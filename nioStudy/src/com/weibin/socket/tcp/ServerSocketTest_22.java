package com.weibin.socket.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/6
 **/
public class ServerSocketTest_22 {

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(8088);
        Socket accept = socket.accept();
        System.out.println("A 是否关闭了Nagle算法：" + accept.getTcpNoDelay());
        accept.setTcpNoDelay(true);
        System.out.println("B 是否关闭了Nagle算法: " + accept.getTcpNoDelay());
        OutputStream out = accept.getOutputStream();
        for (int i = 0; i < 10; i++){
            out.write("1".getBytes());
        }
        accept.close();
        socket.close();
    }

}
