package com.weibin.nio.nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/12
 **/
public class ServerSocketChannelLoopConsume {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress("localhost",7777));
        serverSocketChannel.configureBlocking(false);
        ServerSocketChannel serverSocketChannel1 = ServerSocketChannel.open();
        serverSocketChannel1.bind(new InetSocketAddress("localhost",8888));
        serverSocketChannel1.configureBlocking(false);
        Selector selector = Selector.open();
        SelectionKey selectionKey1 = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        SelectionKey selectionKey2 = serverSocketChannel1.register(selector, SelectionKey.OP_ACCEPT);
        boolean isRun = true;
        while (isRun){
            int select = selector.select();
            Set<SelectionKey> keys1 = selector.keys();
            Set<SelectionKey> keys = selector.selectedKeys();
            System.out.println("count : " + select + "   keys1 : " + keys1.size() + " keys : " + keys.size());
            Iterator<SelectionKey> iterator = keys.iterator();
            while (iterator.hasNext()){
                SelectionKey key = iterator.next();
                iterator.remove();
                ServerSocketChannel channel = (ServerSocketChannel) key.channel();
                SocketChannel channel1 = channel.accept();
                if (channel1 == null){
                    System.out.println("打印这条信息证明是连接8888服务器时，重复消费的情况发生");
                    System.out.println("将7777关联的SelectionKey对应的SpcketChannel取出为NULL");
                }
                InetSocketAddress localAddress = (InetSocketAddress) channel.getLocalAddress();
                System.out.println("port : " + localAddress.getPort() + " 被客户端链接 ");
            }
        }
        serverSocketChannel.close();
        serverSocketChannel1.close();
    }

}
