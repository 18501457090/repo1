package com.weibin.nio.nio;
import java.io.IOException;
import	java.nio.channels.ServerSocketChannel;

import java.nio.channels.ServerSocketChannel;
import java.nio.channels.spi.SelectorProvider;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/11
 **/
public class ServerSocketChannelTest_11 {

    public static void main(String[] args) throws IOException {
        SelectorProvider provider = SelectorProvider.provider();
        System.out.println("provider : " + provider);
        ServerSocketChannel serverSocketChannel = null;
        serverSocketChannel = ServerSocketChannel.open();
        SelectorProvider provider1 = serverSocketChannel.provider();
        System.out.println("default provider : " + provider1);
        serverSocketChannel.close();
    }

}
