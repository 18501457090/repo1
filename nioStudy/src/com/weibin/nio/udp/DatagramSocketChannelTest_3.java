package com.weibin.nio.udp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;
import java.util.Set;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/15
 **/
public class DatagramSocketChannelTest_3 {

    public static void main(String[] args) throws IOException {
        DatagramChannel datagramChannel = DatagramChannel.open();
        datagramChannel.configureBlocking(false);
        datagramChannel.connect(new InetSocketAddress("localhost",8088));
        Selector selector = Selector.open();
        datagramChannel.register(selector, SelectionKey.OP_WRITE);
        selector.select();
        Set<SelectionKey> selectionKeys = selector.selectedKeys();
        Iterator<SelectionKey> iterator = selectionKeys.iterator();
        while (iterator.hasNext()){
            SelectionKey key = iterator.next();
            if (key.isWritable()){
                ByteBuffer buffer = ByteBuffer.wrap("send data to server！ connect".getBytes());
                datagramChannel.write(buffer);
                datagramChannel.close();
            }
        }
    }

}
