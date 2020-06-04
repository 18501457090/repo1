package com.weibin.nio.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/5/6
 **/
public class SocketChannelTest_999 {

    public static void main(String[] args) throws IOException {
        SocketChannel open = SocketChannel.open();
        open.configureBlocking(false);
        open.connect(new InetSocketAddress("localhost", 8088));
        Selector selector = Selector.open();
        open.register(selector, SelectionKey.OP_WRITE | SelectionKey.OP_READ
                | SelectionKey.OP_CONNECT);
        while (true) {
            selector.select();
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = keys.iterator();
            while (iterator.hasNext()) {
                SelectionKey next = iterator.next();
                iterator.remove();
                if (next.isConnectable()) {
                    if (open.isConnectionPending()) {
                        while (!open.finishConnect()) ;
                    }
                }
                if (next.isReadable()) {
                    System.out.println("next.isReadable() : " + next.isReadable());
                    ByteBuffer buffer = ByteBuffer.allocate(512);
                    while (open.read(buffer) != -1) {
                        byte[] array = buffer.array();
                        System.out.println(new String(array, "UTF-8"));
                        buffer.clear();
                    }

                }
                if (next.isWritable()) {
                    System.out.println("next.isWritable() : " + next.isWritable());
                    ByteBuffer buffer = ByteBuffer.wrap("hello , i'm Client".getBytes());
                    open.write(buffer);
                }



            }
        }

    }

}
