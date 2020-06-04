package com.weibin.nio.nio;
import	java.nio.channels.spi.SelectorProvider;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.StandardSocketOptions;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/11
 **/
public class ServerSocketChannelTest_10 {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        socketChannel.bind(new InetSocketAddress("localhost",8088));
        socketChannel.configureBlocking(false);
        Selector selector = Selector.open();
        SelectionKey key = socketChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("key : " + key.getClass().hashCode());
        SelectionKey key1 = socketChannel.keyFor(selector);
        System.out.println("key1 : " + key.getClass().hashCode());

    }

}
