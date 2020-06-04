package com.weibin.socket.tcp;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/5
 **/
public class ServerSocketCloseStatusTest {


    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(800);
        System.out.println(socket.isClosed());
        socket.close();
        System.out.println(socket.isClosed());
    }

}
