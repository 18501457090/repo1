package com.weibin.nio.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/11
 **/
public class ConnectTest_1 {

    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        boolean connect = socketChannel.connect(new InetSocketAddress("localhost", 8088));
        new Thread(()->{
            try {
                Thread.sleep(50);
                ServerSocketChannel socketChannel1 = ServerSocketChannel.open();
                socketChannel1.bind(new InetSocketAddress("localhost",8088));
                SocketChannel accept = socketChannel1.accept();
                accept.close();
                socketChannel1.close();
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        }).start();
        if (connect == false){
            while (!socketChannel.finishConnect()){
                System.out.println("连接中......");
            }
            System.out.println("连接成功！");
        }
    }


}
