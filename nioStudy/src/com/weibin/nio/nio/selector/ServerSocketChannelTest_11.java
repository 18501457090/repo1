package com.weibin.nio.nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/13
 **/
public class ServerSocketChannelTest_11 {

    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        socketChannel.bind(new InetSocketAddress("localhost",8088));
        socketChannel.configureBlocking(false);
        Selector selector = Selector.open();
        SelectionKey selectionKey = socketChannel.register(selector, SelectionKey.OP_ACCEPT);
        boolean isRun = true;
        while (isRun){
            int select = selector.select();
            Set<SelectionKey> set = selector.keys();
            Set<SelectionKey> keys = selector.selectedKeys();
            System.out.println("selectCount : " + select);
            System.out.println("set : " + set.size());
            System.out.println("keys : " + keys.size());
            Iterator<SelectionKey> iterator = keys.iterator();
            while (iterator.hasNext()){
                SelectionKey next = iterator.next();
                ServerSocketChannel channel = (ServerSocketChannel) next.channel();
                SocketChannel accept = channel.accept();
                accept.configureBlocking(false);
                SelectionKey selectionKey1 = accept.register(selector, SelectionKey.OP_READ);
                System.out.println("isReadable() : " + ((SelectionKey.OP_READ & ~selectionKey1.interestOps()) == 0));
                System.out.println("isReadable() : " + ((SelectionKey.OP_WRITE & ~selectionKey1.interestOps()) == 0));
                SelectionKey register = accept.register(selector, SelectionKey.OP_WRITE | SelectionKey.OP_READ);
                System.out.println("isReadable() : " + ((SelectionKey.OP_READ & ~register.interestOps()) == 0));
                System.out.println("isReadable() : " + ((SelectionKey.OP_WRITE & ~register.interestOps()) == 0));
                System.out.println("selectCountB : " + select);
                System.out.println("set : " + set.size());
                System.out.println("keys : " + keys.size());
                System.out.println("两次返回的SelectionKey是否相同 ? " + (selectionKey1 == register));
                System.out.println("两个key比较结果 ： " + (selectionKey == selectionKey1));
            }
            Thread.sleep(Integer.MAX_VALUE);
        }
        socketChannel.close();
    }

}
