package com.weibin.nio.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/12
 **/
public class ClientErrorCodeTest_1 {

    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("localhost",8088));
        System.out.println(socketChannel.isConnected());
        System.out.println(socketChannel.isOpen());
        socketChannel.setOption(StandardSocketOptions.SO_RCVBUF,1234);
        socketChannel.write(ByteBuffer.wrap("send data to server".getBytes()));
        socketChannel.close();
    }

}
