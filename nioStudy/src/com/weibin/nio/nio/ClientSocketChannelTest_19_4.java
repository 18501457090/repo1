package com.weibin.nio.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/11
 **/
public class ClientSocketChannelTest_19_4 {

    public static void main(String[] args) throws IOException {
        SocketChannel channel = SocketChannel.open();
        channel.configureBlocking(false);
        System.out.println("before socketChannel isConnectionPending ? " + channel.isConnectionPending());
        channel.connect(new InetSocketAddress("localhost",8088));
        System.out.println("after socketChannel isConnectionPending ? " + channel.isConnectionPending());
        channel.close();

    }


}
