package com.weibin.nio.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/11
 **/
public class ServerSocketChannelTest_18 {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        //socketChannel.configureBlocking(false);
        socketChannel.bind(new InetSocketAddress("localhost",8088),90);
        SocketChannel socketChannel1 = socketChannel.accept();
        System.out.println("server is Async ? " + socketChannel.isBlocking());
        System.out.println("client is Async ? " + socketChannel1.isBlocking());
        socketChannel1.close();
        socketChannel.close();

    }

}
