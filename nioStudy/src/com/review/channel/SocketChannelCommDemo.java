package com.review.channel;

import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/3/24
 **/
public class SocketChannelCommDemo {

    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        socketChannel.connect(new InetSocketAddress("localhost", 8088));
        Selector selector = Selector.open();
        socketChannel.register(selector, SelectionKey.OP_CONNECT |
                SelectionKey.OP_READ | SelectionKey.OP_WRITE);
        selector.select();
        Set<SelectionKey> selectionKeys = selector.selectedKeys();
        if (!selectionKeys.isEmpty()) {
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                iterator.remove();
                if (key.isConnectable()) {
                    System.out.println("client isConnectable ");
                    if (socketChannel.isConnectionPending()) {
                        System.out.println("isConnectionPending");
                        while (!socketChannel.finishConnect()) ;
                    }
                }
                while (!key.isReadable()) {
                    ByteBuffer buffer = ByteBuffer.allocate(100);
                    socketChannel.read(buffer);
                    buffer.flip();
                    System.out.println("server Data : " + new String(buffer.array()));
                    break;
                }
                while (!key.isWritable()) {
                    ByteBuffer buffer = ByteBuffer.allocate(("client to server data : " + new Date().toLocaleString()).getBytes().length);
                    buffer.put(("client to server data : " + new Date().toLocaleString()).getBytes());
                    buffer.flip();
                    socketChannel.write(buffer);
                    break;
                }


            }
        }


    }

}
