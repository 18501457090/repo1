package com.weibin.nio.nio;

import java.io.IOException;
import java.nio.channels.ServerSocketChannel;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/11
 **/
public class ServerSsocketChannelTest_5 {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        System.out.println("isOpen() : " + socketChannel.isOpen());
        socketChannel.close();
        System.out.println("isOpen() : " + socketChannel.isOpen());
        socketChannel = socketChannel.open();
        System.out.println("isOpen() : " + socketChannel.isOpen());
    }

}
