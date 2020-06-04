package com.weibin.nio.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/12
 **/
public class WriteAndWriteAsyncClientTest {

    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost",8088));
        socketChannel.close();
    }


}
