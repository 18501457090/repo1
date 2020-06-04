package com.weibin.nio.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/5/6
 **/
public class ServerSocketChannelTest_999 {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel channel = ServerSocketChannel.open();
        channel.configureBlocking(false);
        channel.bind(new InetSocketAddress("localhost",8088));
        Selector selector = Selector.open();
        channel.register(selector, SelectionKey.OP_ACCEPT);
        while (true){
            selector.select();
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = keys.iterator();
            while (iterator.hasNext()){
                SelectionKey key = iterator.next();
                iterator.remove();
                if (key.isAcceptable()){
                    SocketChannel accept = channel.accept();
                    accept.configureBlocking(false);
                    accept.register(selector,SelectionKey.OP_WRITE | SelectionKey.OP_READ);
                }
                if (key.isReadable()){
                    System.out.println("111111");
                    SocketChannel sc = (SocketChannel) key.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(512);
                    while (sc.read(buffer) != -1){
                        byte[] array = buffer.array();
                        System.out.println(new String(array,"UTF-8"));
                        buffer.clear();
                    }
                    sc.close();
                }
                if (key.isWritable()){
                    SocketChannel sc = (SocketChannel) key.channel();
                    ByteBuffer wrap = ByteBuffer.wrap("hello i'm Server!".getBytes());
                    System.out.println("begin!!");
                    sc.write(wrap);
                    System.out.println("end!!!");
                    sc.close();
                }
            }

        }


    }

}
