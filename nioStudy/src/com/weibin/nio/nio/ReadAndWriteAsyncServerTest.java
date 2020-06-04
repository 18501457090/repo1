package com.weibin.nio.nio;
import	java.nio.ByteBuffer;

import com.sun.security.ntlm.Server;

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
 * @Date: 2020/1/12
 **/
public class ReadAndWriteAsyncServerTest {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress("localhost",8088));
        Selector open = Selector.open();
        serverSocketChannel.register(open, SelectionKey.OP_ACCEPT);
        open.select();
        Set<SelectionKey> set = open.selectedKeys();
        Iterator<SelectionKey> iterator = set.iterator();
        while (iterator.hasNext()){
            SelectionKey next = iterator.next();
            ServerSocketChannel socketChannel = (ServerSocketChannel) next.channel();
            SocketChannel accept = socketChannel.accept();
            accept.configureBlocking(false);
            ByteBuffer allocate = ByteBuffer.allocate(100);
            System.out.println("begin : " + System.currentTimeMillis());
            accept.read(allocate);
            System.out.println("end : " + System.currentTimeMillis() + " position : " + allocate.position());
        }
        serverSocketChannel.close();
    }

}
