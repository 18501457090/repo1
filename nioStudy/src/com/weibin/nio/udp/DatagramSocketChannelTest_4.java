package com.weibin.nio.udp;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import	java.nio.channels.Selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.DatagramChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/15
 **/
public class DatagramSocketChannelTest_4 {

    public static void main(String[] args) throws IOException {
        DatagramChannel open = DatagramChannel.open();
        open.configureBlocking(false);
        open.connect(new InetSocketAddress("localhost",8088));
        open.disconnect();
        Selector selector = Selector.open();
        open.register(selector, SelectionKey.OP_WRITE);
        selector.select();
        Set<SelectionKey> selectionKeys = selector.selectedKeys();
        Iterator<SelectionKey> iterator = selectionKeys.iterator();
        while (iterator.hasNext()){
            SelectionKey key = iterator.next();
            if (key.isWritable()){
                ByteBuffer buffer = ByteBuffer.wrap("send data to Server !".getBytes());
                open.write(buffer);
                open.close();
            }
        }
    }

}
