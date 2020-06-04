package com.weibin.nio.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/11
 **/
public class ClientSocketChannelTest_18 {

    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        long startTime = System.currentTimeMillis();
        boolean connect = socketChannel.connect(new InetSocketAddress("localhost", 8088));
        long endTime = System.currentTimeMillis();
        System.out.println("is connected ? " + connect + " ------>connectTime : " + (endTime - startTime));
        socketChannel.close();
    }

}
