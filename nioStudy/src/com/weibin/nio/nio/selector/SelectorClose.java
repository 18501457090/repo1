package com.weibin.nio.nio.selector;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import	java.nio.channels.ServerSocketChannel;

import java.io.IOException;
import java.nio.channels.Selector;
import java.util.Iterator;
import java.util.Set;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/14
 **/
public class SelectorClose {
    static Selector selector;
    public static void main(String[] args) throws IOException {
        new Thread(()->{
            try {
                Thread.sleep(1000);
                selector.close();
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        }).start();
        selector = Selector.open();
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.bind(new InetSocketAddress("localhost",8088));
        serverChannel.configureBlocking(false);
        SelectionKey register = serverChannel.register(selector, SelectionKey.OP_ACCEPT);
        
        selector.select();
        Set<SelectionKey> selectionKeys = selector.selectedKeys();
        try {
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()){
                SelectionKey next = iterator.next();
                System.out.println(next.isValid());
            }
        } catch (Exception e){
            selector = Selector.open();
            e.printStackTrace();
        }
        System.out.println("选择器恢复连接了 ： " + selector.isOpen());

    }

}
