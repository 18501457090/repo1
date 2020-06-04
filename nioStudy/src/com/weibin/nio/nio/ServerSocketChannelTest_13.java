package com.weibin.nio.nio;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/11
 **/
public class ServerSocketChannelTest_13 {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel socketChannel1 = ServerSocketChannel.open();
        ServerSocketChannel socketChannel2 = ServerSocketChannel.open();
        socketChannel1.configureBlocking(false);
        socketChannel2.configureBlocking(false);
        Selector selector = Selector.open();
        SelectionKey key1 = socketChannel1.register(selector, SelectionKey.OP_ACCEPT);
        SelectionKey key2 = socketChannel2.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("key1 : " + key1);
        System.out.println("key2 : " + key2);
        socketChannel1.close();
        socketChannel2.close();
    }

}
