package com.weibin.nio.nio.selectionkey;
import	java.nio.ByteBuffer;
import java.nio.ByteBuffer;
import java.nio.channels.*;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.Selector;
import java.util.Iterator;
import java.util.Set;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/15
 **/
public class SelectionReadyOpsTest {

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
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = keys.iterator();
            while (iterator.hasNext()){
                SelectionKey key = iterator.next();
                System.out.println("key.readyOps : " + key.readyOps() + " accept : " + SelectionKey.OP_ACCEPT + "  " +
                        "connect : " + SelectionKey.OP_CONNECT + " read : " + SelectionKey.OP_READ  + "  write : " + SelectionKey.OP_WRITE);
                if (key.isAcceptable()){
                    ServerSocketChannel serverSocketChannel1 = (ServerSocketChannel) key.channel();
                    System.out.println("server isAcceptable OP_ACCEPT : " + (SelectionKey.OP_ACCEPT & ~key.readyOps()));
                    System.out.println("server isAcceptable OP_CONNECT : " + (SelectionKey.OP_CONNECT & ~key.readyOps()));
                    System.out.println("server isAcceptable OP_READ : " + (SelectionKey.OP_READ & ~key.readyOps()));
                    System.out.println("server isAcceptable OP_WRITE : " + (SelectionKey.OP_WRITE & ~key.readyOps()));
                    socketChannel = serverSocketChannel1.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector,SelectionKey.OP_READ);
                }
                if (key.isReadable()){
                    System.out.println("server isReadable OP_ACCEPT : " + (SelectionKey.OP_ACCEPT & ~key.readyOps()));
                    System.out.println("server isReadable OP_CONNECT : " + (SelectionKey.OP_CONNECT & ~key.readyOps()));
                    System.out.println("server isReadable OP_READ : " + (SelectionKey.OP_READ & ~key.readyOps()));
                    System.out.println("server isReadable OP_WRITE : " + (SelectionKey.OP_WRITE & ~key.readyOps()));
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1000);
                    int read = socketChannel.read(byteBuffer);
                    while (read != -1){
                        System.out.println(new String(byteBuffer.array(),0,read));
                        read = socketChannel.read(byteBuffer);
                    }
                    socketChannel.close();
                }
                iterator.remove();
            }
            serverSocketChannel.close();
        }
    }

}
