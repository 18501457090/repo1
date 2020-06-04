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
public class SelectorTest_1 {

    public static void main(String[] args) throws IOException {
        Selector open = Selector.open();
        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        socketChannel.configureBlocking(false);
        ServerSocket serverSocket = socketChannel.socket();
        serverSocket.bind(new InetSocketAddress("localhost",8088));
        SelectionKey selectionKey = socketChannel.register(open, SelectionKey.OP_ACCEPT);
        System.out.println("selector : " + open);
        System.out.println("selectionKey : " + selectionKey);
        //SelectionKey register = socketChannel.register(open);
    }

}
