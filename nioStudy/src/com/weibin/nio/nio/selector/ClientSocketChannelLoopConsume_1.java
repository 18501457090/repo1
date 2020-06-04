package com.weibin.nio.nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.SocketChannel;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/12
 **/
public class ClientSocketChannelLoopConsume_1 {

    public static void main(String[] args) throws IOException {
        test2();
    }
    public static void test2() throws IOException {
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress("localhost",8888));
        socket.close();
        /*SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost",8888));
        socketChannel.close();*/
    }
}
