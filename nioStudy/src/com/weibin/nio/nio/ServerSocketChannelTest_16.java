package com.weibin.nio.nio;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/11
 **/
public class ServerSocketChannelTest_16 {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        SocketChannel channel = SocketChannel.open();
        int validOps = socketChannel.validOps();
        int validOps1 = channel.validOps();
        System.out.println("Server : " + validOps);
        System.out.println("Client : " + validOps1);
        // ServerSocketChannel 只支持OP_ACCEPT
        System.out.print(SelectionKey.OP_ACCEPT & ~socketChannel.validOps());
        System.out.print(SelectionKey.OP_CONNECT & ~socketChannel.validOps());
        System.out.print(SelectionKey.OP_READ & ~socketChannel.validOps());
        System.out.print(SelectionKey.OP_WRITE & ~socketChannel.validOps());
        // SocketChannel支持OP_CONNECT、OP_READ、OP_WRITE
        System.out.println(SelectionKey.OP_ACCEPT & ~channel.validOps());
        System.out.println(SelectionKey.OP_CONNECT & ~channel.validOps());
        System.out.println(SelectionKey.OP_READ & ~channel.validOps());
        System.out.println(SelectionKey.OP_WRITE & ~channel.validOps());
        socketChannel.close();
        channel.close();

    }

}
