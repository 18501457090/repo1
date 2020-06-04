package com.weibin.nio.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Objects;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/11
 **/
public class ServerSocketChanneltest_4 {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        socketChannel.bind(new InetSocketAddress("localhost",8088));
        socketChannel.configureBlocking(false); // 使用非阻塞执行模式
        System.out.println("begin : " + System.currentTimeMillis());
        SocketChannel accept = socketChannel.accept();
        System.out.println("end :" + System.currentTimeMillis());
        if (Objects.nonNull(accept)){
            accept.close();
        }
        socketChannel.close();
    }

}
