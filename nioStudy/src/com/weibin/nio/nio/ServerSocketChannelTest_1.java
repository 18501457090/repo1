package com.weibin.nio.nio;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.ServerSocketChannel;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/11
 **/
public class ServerSocketChannelTest_1 {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        ServerSocket serverSocket = socketChannel.socket();
        serverSocket.bind(new InetSocketAddress("localhost",8088));
        Socket accept = serverSocket.accept();
        InputStream inputStream = accept.getInputStream();
        InputStreamReader reader = new InputStreamReader(inputStream);
        char[] chars = new char[1024];
        int read = reader.read(chars);
        while (read != -1){
            System.out.println(new String(chars,0,read));
            read = reader.read(chars);
        }
        inputStream.close();
        serverSocket.close();
        socketChannel.close();
    }

}
