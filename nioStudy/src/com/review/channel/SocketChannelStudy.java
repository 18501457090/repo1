package com.review.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/3/24
 **/
public class SocketChannelStudy {

    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open(
                new InetSocketAddress("localhost", 8088));
        // 等价于
        SocketChannel socketChannel1 = SocketChannel.open();
        socketChannel1.connect(new InetSocketAddress("localhost",8088));
    }

}
