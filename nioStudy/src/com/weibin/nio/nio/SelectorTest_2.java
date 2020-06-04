package com.weibin.nio.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/11
 **/
public class SelectorTest_2 {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        socketChannel.configureBlocking(false);
        ServerSocket socket = socketChannel.socket();
        socket.bind(new InetSocketAddress("localhost",8088));
        System.out.println("before isRegistered ? " + socketChannel.isRegistered());
        Selector selector = Selector.open();
        SelectionKey key = socketChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("after isRegistered ? " + socketChannel.isRegistered());
        socket.close();
        socketChannel.close();
    }


}
