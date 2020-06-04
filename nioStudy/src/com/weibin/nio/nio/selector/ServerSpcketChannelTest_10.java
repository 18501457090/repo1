package com.weibin.nio.nio.selector;
import	java.nio.ByteBuffer;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/12
 **/
public class ServerSpcketChannelTest_10 {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress("localhost",8088));
        serverSocketChannel.configureBlocking(false);
        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        boolean isRun = true;
        while (isRun){
            selector.select();
            Set<SelectionKey> set = selector.selectedKeys();
            Iterator<SelectionKey> iterator = set.iterator();
            while (iterator.hasNext()){
                SelectionKey next = iterator.next();
                if (next.isAcceptable()){
                    ServerSocketChannel channel = (ServerSocketChannel) next.channel();
                    ServerSocket socket = channel.socket();
                    Socket accept = socket.accept();
                    InputStream inputStream = accept.getInputStream();
                    byte[] bytes = new byte[1024];
                    int read = inputStream.read(bytes);
                    while (read != -1){
                        System.out.println(new String(bytes,0,read));
                        read = inputStream.read(bytes);
                    }
                    inputStream.close();
                    socket.close();
                    iterator.remove();
                }
            }
        }
        serverSocketChannel.close();
    }

}
