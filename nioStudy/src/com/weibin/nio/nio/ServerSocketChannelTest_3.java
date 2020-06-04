package com.weibin.nio.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/11
 **/
public class ServerSocketChannelTest_3 {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        socketChannel.bind(new InetSocketAddress("localhost",8088));
        System.out.println("默认执行模式为 ？ " + socketChannel.isBlocking());
        System.out.println("begin : " + System.currentTimeMillis());
        SocketChannel accept = socketChannel.accept();
        System.out.println("end : " + System.currentTimeMillis());
        accept.close();
        socketChannel.close();
    }

}
