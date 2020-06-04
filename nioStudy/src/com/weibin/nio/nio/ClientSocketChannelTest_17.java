package com.weibin.nio.nio;
import java.io.IOException;
import java.net.InetSocketAddress;
import	java.nio.channels.SocketChannel;

import java.net.Socket;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/11
 **/
public class ClientSocketChannelTest_17 {

    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        long start = System.currentTimeMillis();
        boolean connect = socketChannel.connect(new InetSocketAddress("localhost", 8088));
        long end = System.currentTimeMillis();
        System.out.println("isConnected ? " + connect + " -----> connectTime : " + (end - start));
        socketChannel.close();
    }

}
