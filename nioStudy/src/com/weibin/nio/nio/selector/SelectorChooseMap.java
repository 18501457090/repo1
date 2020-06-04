package com.weibin.nio.nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/13
 **/
public class SelectorChooseMap {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress("localhost",8888));
        serverSocketChannel.configureBlocking(false);
        ServerSocketChannel serverSocketChannel2 = ServerSocketChannel.open();
        serverSocketChannel2.bind(new InetSocketAddress("localhost",9999));
        serverSocketChannel2.configureBlocking(false);
        ServerSocketChannel serverSocketChannel3 = ServerSocketChannel.open();
        serverSocketChannel3.bind(new InetSocketAddress("localhost",7777));
        serverSocketChannel3.configureBlocking(false);
        Selector selector = Selector.open();
        SelectionKey register1 = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        SelectionKey register2 = serverSocketChannel2.register(selector, SelectionKey.OP_ACCEPT);
        SelectionKey register3 = serverSocketChannel3.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println(register1.hashCode());
        System.out.println(register2.hashCode());
        System.out.println(register3.hashCode());
        System.out.println(" -- - -- ---  -- - - - - - -- ");
        Set<SelectionKey> keys = selector.keys();
        Iterator<SelectionKey> iterator = keys.iterator();
        while (iterator.hasNext()){
            SelectionKey next = iterator.next();
            System.out.println(next.hashCode());
        }
    }

}
