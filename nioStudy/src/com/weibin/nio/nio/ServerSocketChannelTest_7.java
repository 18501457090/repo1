package com.weibin.nio.nio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.StandardSocketOptions;
import java.nio.channels.ServerSocketChannel;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/11
 **/
public class ServerSocketChannelTest_7 {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        // 通道支持什么，Socket Option就只能设置什么，设置其他的Socket option就会出现异常
        System.out.println("A SO_RCVBUF : " + socketChannel.getOption(StandardSocketOptions.SO_RCVBUF));
        socketChannel.setOption(StandardSocketOptions.SO_RCVBUF,5678);
        System.out.println("A SO_RCVBUF : " + socketChannel.getOption(StandardSocketOptions.SO_RCVBUF));
        socketChannel.close();
    }


}
