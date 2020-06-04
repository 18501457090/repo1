package com.weibin.socket.tcp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/5
 **/
public class ServerSocketAddressTest {

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket();
        socket.bind(new InetSocketAddress("192.168.1.8",8088),80);
        System.out.println(socket.getInetAddress().getHostAddress());
        System.out.println(socket.getInetAddress().getCanonicalHostName());
    }

}
