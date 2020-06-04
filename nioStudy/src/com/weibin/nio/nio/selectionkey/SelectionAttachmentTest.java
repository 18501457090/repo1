package com.weibin.nio.nio.selectionkey;
import	java.nio.ByteBuffer;

import sun.reflect.generics.tree.VoidDescriptor;

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
public class SelectionAttachmentTest {


    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress("localhost",8088));
        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        SocketChannel socketChannel = null;
        boolean isRunning = true;
        while (isRunning){
            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()){
                SelectionKey key = iterator.next();
                if (key.isAcceptable()){
                    ServerSocketChannel serverSocketChannel1 = (ServerSocketChannel) key.channel();
                    socketChannel = serverSocketChannel1.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector,SelectionKey.OP_READ);
                }
                if (key.isReadable()){
                    System.out.println("server isReadable!");
                    ByteBuffer allocate = ByteBuffer.allocate(100);
                    int read = socketChannel.read(allocate);
                    while (read != -1){
                        System.out.println(new String(allocate.array(),0,read));
                        read = socketChannel.read(allocate);
                    }
                    socketChannel.close();
                }
                iterator.remove();
            }
            serverSocketChannel.close();
        }

    }



}
