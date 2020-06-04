package com.weibin.socket.tcp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/5
 **/
public class ServerSocketBoundTest_2 {

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket();
        // 绑定到一个不存在的网址
        InetSocketAddress address = new InetSocketAddress("www.baidu.360.com",8088);
        System.out.println(socket.isBound());
        socket.bind(address);
        System.out.println(socket.isBound());
    }

}
