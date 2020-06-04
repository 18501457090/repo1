package com.weibin.nio.nio.selector;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import	java.nio.channels.SocketChannel;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/13
 **/
public class CancleSelectionKeyClientTest_1 {

    public static void main(String[] args) throws IOException {
        SocketChannel channel = SocketChannel.open();
        channel.connect(new InetSocketAddress("localhost",8088));
        channel.write(ByteBuffer.wrap("send Data to Server for 8088 port ! ".getBytes()));
        channel.close();

        SocketChannel channel2 = SocketChannel.open();
        channel2.connect(new InetSocketAddress("localhost",9099));
        channel2.write(ByteBuffer.wrap("send Data to Server for 9099 port !".getBytes()));
        channel2.close();
    }


}
