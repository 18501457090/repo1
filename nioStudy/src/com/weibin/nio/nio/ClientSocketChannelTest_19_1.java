package com.weibin.nio.nio;
import	java.net.Socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/11
 **/
public class ClientSocketChannelTest_19_1 {

    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        System.out.println("socketChannel isConnectionPending ? " + socketChannel.isConnectionPending());
        socketChannel.connect(new InetSocketAddress("192.168.0.123",8088)); // 此IP地址不存在
        socketChannel.close();
    }


}
