package com.weibin.nio.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.ServerSocketChannel;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/11
 **/
public class ServerSocketChannelTest_2 {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        socketChannel.bind(new InetSocketAddress("localshot",8088),100);
        ServerSocket serverSocket = socketChannel.socket();
    }

}
