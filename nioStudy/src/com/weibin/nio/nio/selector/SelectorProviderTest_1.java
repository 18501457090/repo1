package com.weibin.nio.nio.selector;
import	java.nio.channels.SelectionKey;
import	java.nio.channels.spi.SelectorProvider;
import	java.nio.channels.SocketChannel;

import java.io.IOException;
import java.nio.channels.Selector;
import java.nio.channels.spi.SelectorProvider;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/13
 **/
public class SelectorProviderTest_1 {

    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        Selector selector = Selector.open();
        final SelectionKey register = socketChannel.register(selector, SelectionKey.OP_READ);
        selector.close();
        System.out.println("selector isOpen ? " + selector.isOpen());
        System.out.println("channel isOpen ? " + socketChannel.isOpen());
    }


}
