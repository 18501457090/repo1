package com.review.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/3/24
 **/
public class ConnectAsync {

    public static void main(String[] args) throws IOException, InterruptedException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        socketChannel.connect(new InetSocketAddress("localhost",8088));
        System.out.println("是否可以结束连接? : " + socketChannel.finishConnect());
        System.out.println("是否正在连接? : " + socketChannel.isConnectionPending());
        while (!socketChannel.finishConnect()){
            System.out.println("连接是否已经完成 ? : " + socketChannel.isConnected());
            Thread.sleep(1000);
        }


    }

}
