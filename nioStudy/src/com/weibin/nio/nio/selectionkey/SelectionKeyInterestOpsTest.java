package com.weibin.nio.nio.selectionkey;
import	java.nio.channels.SelectionKey;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/15
 **/
public class SelectionKeyInterestOpsTest {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress("localhost",8088));
        SocketChannel socketChannel1 = SocketChannel.open();
        socketChannel1.configureBlocking(false);
        SocketChannel socketChannel2 = SocketChannel.open();
        socketChannel2.configureBlocking(false);
        Selector selector = Selector.open();
        SelectionKey key1 = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        SelectionKey key2 = socketChannel1.register(selector, SelectionKey.OP_CONNECT | SelectionKey.OP_READ);
        SelectionKey key3 = socketChannel2.register(selector, SelectionKey.OP_CONNECT | SelectionKey.OP_READ |
                SelectionKey.OP_WRITE);

        System.out.println(~key1.interestOps() & SelectionKey.OP_ACCEPT);
        System.out.println(~key1.interestOps() & SelectionKey.OP_CONNECT);
        System.out.println(~key1.interestOps() & SelectionKey.OP_READ);
        System.out.println(~key1.interestOps() & SelectionKey.OP_WRITE);
        System.out.println("key1---------------------------------------");
        System.out.println(~key2.interestOps() & SelectionKey.OP_ACCEPT);
        System.out.println(~key2.interestOps() & SelectionKey.OP_CONNECT);
        System.out.println(~key2.interestOps() & SelectionKey.OP_READ);
        System.out.println(~key2.interestOps() & SelectionKey.OP_WRITE);
        System.out.println("key2---------------------------------------");
        System.out.println(~key3.interestOps() & SelectionKey.OP_ACCEPT);
        System.out.println(~key3.interestOps() & SelectionKey.OP_CONNECT);
        System.out.println(~key3.interestOps() & SelectionKey.OP_READ);
        System.out.println(~key3.interestOps() & SelectionKey.OP_WRITE);





    }

}
