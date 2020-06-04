package com.weibin.nio.nio.selectionkey;
import java.io.IOException;
import java.net.InetSocketAddress;
import	java.nio.channels.SocketChannel;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/15
 **/
public class SelectionKeyCancelClientTest {

    public static void main(String[] args) throws IOException {
        SocketChannel channel = SocketChannel.open();
        channel.configureBlocking(false);
        channel.connect(new InetSocketAddress("localhost",8088));
        channel.close();
    }


}
