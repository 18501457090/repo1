package com.weibin.nio.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/11
 **/
public class SocketChannelTest_6 {

    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        boolean connect = socketChannel.connect(new InetSocketAddress("localhost", 8088));
        if (connect == false){
            System.out.println("connected : " + connect);
            while (!socketChannel.finishConnect()){
                System.out.println("尝试连接中......");
            }
        }
        socketChannel.close();
    }

}
