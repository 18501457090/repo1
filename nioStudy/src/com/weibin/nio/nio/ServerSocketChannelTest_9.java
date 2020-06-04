package com.weibin.nio.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/11
 **/
public class ServerSocketChannelTest_9 {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        socketChannel.bind(new InetSocketAddress("localhost",8088));
        System.out.println("create isBlocking ? " + socketChannel.isBlocking());
        socketChannel.configureBlocking(false);
        System.out.println("setting isBlocking ? " + socketChannel.isBlocking());
        socketChannel.close();
        System.out.println("closed isBlocking ? " + socketChannel.isBlocking());

    }



}
