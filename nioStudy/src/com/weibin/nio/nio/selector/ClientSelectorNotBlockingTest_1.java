package com.weibin.nio.nio.selector;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import	java.nio.channels.SocketChannel;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/12
 **/
public class ClientSelectorNotBlockingTest_1 {

    public static void main(String[] args) throws IOException {
        SocketChannel channel = SocketChannel.open();
        channel.connect(new InetSocketAddress("localhost",8088));
        channel.close();
    }

}
