package com.weibin.nio.nio.selectionkey;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/15
 **/
public class SelectionKeyGetSelectorTest {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress("localhost",8088));
        Selector selector = Selector.open();
        SelectionKey selectionKey = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        selectionKey.cancel();
        Selector selector1 = selectionKey.selector();
        System.out.println("selector : " + selector.hashCode());
        System.out.println("SelectionKey.selector() : " + selector1.hashCode());
        serverSocketChannel.close();

    }

}
