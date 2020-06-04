package com.weibin.nio.nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
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
public class SelectorTest_3 {

    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress("localhost",7777));
        serverSocketChannel.configureBlocking(false);
        ServerSocketChannel serverSocketChanne2 = ServerSocketChannel.open();
        serverSocketChanne2.bind(new InetSocketAddress("localhost",8888));
        serverSocketChanne2.configureBlocking(false);
        ServerSocketChannel serverSocketChanne3 = ServerSocketChannel.open();
        serverSocketChanne3.bind(new InetSocketAddress("localhost",9999));
        serverSocketChanne3.configureBlocking(false);
        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        serverSocketChanne2.register(selector, SelectionKey.OP_ACCEPT);
        serverSocketChanne3.register(selector, SelectionKey.OP_ACCEPT);
        boolean isRun = true;
        while (isRun){
            int select = selector.select();
            Set<SelectionKey> set1 = selector.selectedKeys();
            Set<SelectionKey> set = selector.keys();
            System.out.println("selectCount : " + select + " set : " + set.size() + " set1 : "  + set1.size());
            Iterator<SelectionKey> iterator = set1.iterator();
            while (iterator.hasNext()){
                SelectionKey key = iterator.next();
                ServerSocketChannel serverSocketChannel1 = (ServerSocketChannel) key.channel();
                serverSocketChannel1.accept();
            }
            Thread.sleep(10000);
        }
        serverSocketChannel.close();
        serverSocketChanne2.close();
        serverSocketChanne3.close();
    }


}
