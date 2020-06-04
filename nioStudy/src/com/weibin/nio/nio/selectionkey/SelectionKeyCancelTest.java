package com.weibin.nio.nio.selectionkey;

import com.sun.security.ntlm.Server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/15
 **/
public class SelectionKeyCancelTest {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress("localhost",8088));
        Selector selector = Selector.open();
        serverSocketChannel.register(selector, 16);
        new Thread(()->{
            try {
                Thread.sleep(3000);
                System.out.println("cancel() after selector.keys().size() : " + selector.keys().size());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        boolean isRunning = true;
        while (isRunning){
            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            System.out.println("cancel() before selector.key().size() : " + selector.keys().size());
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()){
                SelectionKey key = iterator.next();
                if (key.isAcceptable()){
                    ServerSocketChannel channel = (ServerSocketChannel) key.channel();
                    SocketChannel socketChannel1 = channel.accept();
                }
                key.cancel();
            }
        }
        serverSocketChannel.close();

    }

}
