package com.weibin.nio.nio.selectionkey;

import java.nio.ByteBuffer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/15
 **/
public class SelectionKeyIsReadableTest {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress("localhost", 8088));
        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        SocketChannel socketChannel = null;
        boolean isRun = true;
        while (isRun) {
            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            boolean empty = selectionKeys.isEmpty();
            System.out.println("empty : " + empty);
            if (!empty) {
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    if (key.isAcceptable()) {
                        ServerSocketChannel serverSocketChannel1 = (ServerSocketChannel) key.channel();
                        socketChannel = serverSocketChannel1.accept();
                        socketChannel.configureBlocking(false);
                        socketChannel.register(selector, SelectionKey.OP_READ);
                    }
                    if (key.isReadable()) {
                        System.out.println("server isReadyAble!");
                        ByteBuffer byteBuffer = ByteBuffer.allocate(1000);
                        int read = socketChannel.read(byteBuffer);
                        while (read != -1) {
                            System.out.println(new String(byteBuffer.array(), 0, read));
                            read = socketChannel.read(byteBuffer);
                        }
                        socketChannel.close();
                    }
                    iterator.remove();
                }
            }
            serverSocketChannel.close();
        }

    }

}
