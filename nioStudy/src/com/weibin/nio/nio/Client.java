package com.weibin.nio.nio;
import	java.nio.ByteBuffer;
import java.net.InetSocketAddress;
import	java.net.StandardSocketOptions;

import java.io.IOException;
import java.nio.channels.SocketChannel;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/12
 **/
public class Client {

    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.setOption(StandardSocketOptions.SO_RCVBUF,1234);
        socketChannel.connect(new InetSocketAddress("localhost",8088));
        socketChannel.write(ByteBuffer.wrap(("send data to server").getBytes()));
        socketChannel.close();

    }

}
