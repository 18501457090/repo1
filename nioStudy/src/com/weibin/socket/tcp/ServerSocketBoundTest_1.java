package com.weibin.socket.tcp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/5
 **/
public class ServerSocketBoundTest_1 {

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket();
        System.out.println(socket.isBound());
        socket.bind(new InetSocketAddress(8088));
        System.out.println(socket.isBound());
        socket.close();
    }

}
