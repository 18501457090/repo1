package com.weibin.nio.nio;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/11
 **/
public class ServerSocketChannelTest_5 {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        socketChannel.bind(new InetSocketAddress("localhost",8088));
        SocketChannel accept = socketChannel.accept();
        ByteBuffer buffer = ByteBuffer.allocate(2);
        int read = accept.read(buffer);
        while (read != -1){
            byte[] array = buffer.array();
            String str = new String(array);
            System.out.println(str);
            buffer.flip();
            read = accept.read(buffer);
        }
        accept.close();
        socketChannel.close();
    }

}
