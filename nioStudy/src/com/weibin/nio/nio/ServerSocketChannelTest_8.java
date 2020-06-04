package com.weibin.nio.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/11
 **/
public class ServerSocketChannelTest_8 {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        socketChannel.bind(new InetSocketAddress("localhost",8088));
        InetSocketAddress socketAddress = (InetSocketAddress) socketChannel.getLocalAddress();
        System.out.println("HostString : " + socketAddress.getHostString());
        System.out.println("port : " + socketAddress.getPort());
    }

}
