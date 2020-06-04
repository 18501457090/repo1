package com.weibin.socket.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/5
 **/
public class ServerSocketWriteHalfTest {

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(8088);
        Socket accept = socket.accept();
        OutputStream out = accept.getOutputStream();
        out.write("123".getBytes());
        accept.shutdownOutput(); // 终止序列
        out = accept.getOutputStream();// 抛出异常
        out.write("456".getBytes());   //抛出异常
        accept.close();
        socket.close();
    }

}
