package com.weibin.nio.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketOption;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/11
 **/
public class ServerSocketChannelTest_6 {

    public static void main(String[] args) throws IOException {
        new Thread(()->{
            try {
                Thread.sleep(2000);
                Socket socket = new Socket("localhost",8088);
                //socket.bind(new InetSocketAddress("localhost",8088)); // 使用这种方式会出现端口占用异常
                socket.close();
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        }).start();
        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        socketChannel.bind(new InetSocketAddress("localhost",8088));
        SocketChannel accept = socketChannel.accept();
        Set<SocketOption<?>> socketOptions = socketChannel.supportedOptions();
        Set<SocketOption<?>> supportedOptions = accept.supportedOptions();
        Iterator<SocketOption<?>> iterator = socketOptions.iterator();
        Iterator<SocketOption<?>> iterator1 = supportedOptions.iterator();
        System.out.println("ServerSocketChannel supportOptions : ");
        while (iterator.hasNext()){
            SocketOption<?> option = iterator.next();
            System.out.println("className : " + option.getClass().getName());
        }
        System.out.println(" --------------------------------- ");
        System.out.println("SocketChannel supportOptions : ");
        while (iterator1.hasNext()){
            SocketOption<?> option = iterator1.next();
            System.out.println("className : " + option.getClass().getName());
        }
        accept.close();
        socketChannel.close();


    }


}
