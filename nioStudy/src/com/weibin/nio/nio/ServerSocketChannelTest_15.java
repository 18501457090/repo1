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
public class ServerSocketChannelTest_15 {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel channel = ServerSocketChannel.open();
        channel.configureBlocking(false);
        Selector selector = Selector.open();
        SelectionKey key1 = channel.register(selector, SelectionKey.OP_ACCEPT);
        SelectionKey key2 = channel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("key1 : " + key1);
        System.out.println("key2 : " + key2);
        channel.close();
    }

}
