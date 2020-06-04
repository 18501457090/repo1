package com.review.channel;
import	java.nio.ByteBuffer;
import	java.nio.channels.SelectionKey;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/3/24
 **/
public class ServerSocketCommDemo {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress("localhost",8088));
        serverSocketChannel.configureBlocking(false);
        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        boolean isRun = true;
        while (isRun){
            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            if (!selectionKeys.isEmpty()){
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()){
                    SelectionKey key = iterator.next();
                    iterator.remove();
                    SocketChannel channel;
                    if (key.isAcceptable()){
                        ServerSocketChannel ssc =
                                (ServerSocketChannel) key.channel();
                        channel = ssc.accept();
                        System.out.println("key.isAcceptable()方法执行了一次!!!");
                        channel.configureBlocking(false);
                        channel.register(selector,SelectionKey.OP_WRITE | SelectionKey.OP_READ);
                    }
                    if (key.isWritable()){
                        ByteBuffer buffer = ByteBuffer.allocate(100);
                        buffer.put(("i'm Server : " + new Date().toLocaleString()).getBytes());
                        buffer.flip();
                        channel = (SocketChannel) key.channel();
                        int write = channel.write(buffer);
                        System.out.println("写入了 " + write + "字节！");
                    }
                    if (key.isReadable()){
                        ByteBuffer buffer = ByteBuffer.allocate(100);
                        channel = (SocketChannel) key.channel();
                        int read = channel.read(buffer);
                        System.out.println("读入了 " + read + "字节!!!");
                        buffer.flip();
                        System.out.println("client Data : " + new String(buffer.array()));
                    }
                }
            }



        }


    }

}
