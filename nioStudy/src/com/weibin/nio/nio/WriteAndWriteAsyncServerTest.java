package com.weibin.nio.nio;

import java.nio.ByteBuffer;
import	java.nio.channels.SelectionKey;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/12
 **/
public class WriteAndWriteAsyncServerTest {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress("localhost",8088));
        Selector selector = Selector.open();
        serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);
        selector.select();
        Set<SelectionKey> set = selector.selectedKeys();
        Iterator<SelectionKey> iterator = set.iterator();
        while (iterator.hasNext()){
            SelectionKey next = iterator.next();
            ServerSocketChannel serverSocketChannel1 = (ServerSocketChannel) next.channel();
            SocketChannel socketChannel = serverSocketChannel.accept();
            socketChannel.configureBlocking(false);
            ByteBuffer byteBuffer = ByteBuffer.allocate(Integer.MAX_VALUE / 10);
            System.out.println("limit : " + byteBuffer.limit());
            System.out.println("begin : " + System.currentTimeMillis());
            socketChannel.write(byteBuffer);
            System.out.println("end : " + System.currentTimeMillis());
            System.out.println("position ： " + byteBuffer.position());
        }
        serverSocketChannel.close();
    }


}
