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
public class DatagramSocketChannelTest_1 {

    public static void main(String[] args) throws IOException {
        DatagramChannel datagramChannel = DatagramChannel.open();
        datagramChannel.configureBlocking(false);
        datagramChannel.bind(new InetSocketAddress("localhost",8088));
        Selector selector = Selector.open();
        datagramChannel.register(selector, SelectionKey.OP_READ);
        boolean isRunning = true;
        while (isRunning){
            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()){
                SelectionKey key = iterator.next();
                if (key.isReadable()){
                    datagramChannel = (DatagramChannel) key.channel();
                    ByteBuffer allocate = ByteBuffer.allocate(1000);
                    datagramChannel.receive(allocate);
                    System.out.println(new String(allocate.array(),0,allocate.position()));
                }
                iterator.remove();
            }
        }
        datagramChannel.close();
    }

}
