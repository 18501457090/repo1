package com.weibin.nio.nio;
import	java.nio.ByteBuffer;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/12
 **/
public class ServerSocketChannelReceiveBigDataTest {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress("localhost",8088));
        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        boolean isRun = true;
        while (isRun){
            selector.select();
            Set<SelectionKey> set = selector.selectedKeys();
            Iterator<SelectionKey> iterator = set.iterator();
            while (iterator.hasNext()){
                SelectionKey key = iterator.next();
                iterator.remove();
                if (key.isAcceptable()){
                    SocketChannel channel = serverSocketChannel.accept();
                    channel.configureBlocking(false);
                    channel.register(selector,SelectionKey.OP_WRITE);
                }
                if (key.isWritable()){
                    SocketChannel socketChannel = (SocketChannel) key.channel();
                    FileInputStream in = new FileInputStream("D:\\Channel\\Data\\write\\DatagramSocketWrite.txt");
                    FileChannel channel = in.getChannel();
                    ByteBuffer buffer = ByteBuffer.allocateDirect(1024 * 1024 * 1024);
                    while (channel.position() < channel.size()){
                        channel.read(buffer);
                        buffer.flip();
                        while (buffer.hasRemaining()){
                            socketChannel.write(buffer);
                        }
                        buffer.clear();
                        System.out.println("fileChannel position : " + channel.position() + " size : " + channel.size());
                    }
                    System.out.println("结束写操作");
                    socketChannel.close();
                }
            }
        }
        serverSocketChannel.close();
    }


}
