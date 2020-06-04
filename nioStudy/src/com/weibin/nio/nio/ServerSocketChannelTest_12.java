package com.weibin.nio.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/11
 **/
public class ServerSocketChannelTest_12 {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        socketChannel.bind(new InetSocketAddress("localhost",8088));
        socketChannel.configureBlocking(false);
        Selector selector1 = Selector.open();
        Selector selector2 = Selector.open();
        SelectionKey key1 = socketChannel.register(selector1, SelectionKey.OP_ACCEPT);
        System.out.println("key1 : " + key1.hashCode());
        SelectionKey key2 = socketChannel.register(selector2, SelectionKey.OP_ACCEPT);
        System.out.println("key2 : " + key2.hashCode());
        socketChannel.close();
    }


}
