package com.weibin.nio.udp;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import	java.nio.channels.Selector;

import java.io.IOException;
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
public class DatagramSocketChannelTest_2 {

    public static void main(String[] args) throws IOException {
        DatagramChannel channel = DatagramChannel.open();
        channel.configureBlocking(false);
        Selector selector = Selector.open();
        channel.register(selector, SelectionKey.OP_WRITE);
        selector.select();
        Set<SelectionKey> keys = selector.selectedKeys();
        Iterator<SelectionKey> iterator = keys.iterator();
        while (iterator.hasNext()){
            SelectionKey key = iterator.next();
            if (key.isWritable()){
                ByteBuffer wrap = ByteBuffer.wrap("send data to Server".getBytes());
                channel.send(wrap,new InetSocketAddress("localhost",8088));
                channel.close();
            }
        }
    }

}
