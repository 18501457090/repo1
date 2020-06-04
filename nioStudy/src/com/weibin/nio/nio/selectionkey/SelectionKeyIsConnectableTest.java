package com.weibin.nio.nio.selectionkey;
import java.nio.channels.SelectionKey;
import	java.nio.channels.Selector;
import java.io.IOException;
import java.net.InetSocketAddress;
import	java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/15
 **/
public class SelectionKeyIsConnectableTest {

    public static void main(String[] args) throws IOException {
        SocketChannel channel = SocketChannel.open();
//        channel.connect(new InetSocketAddress("localhost",8088)); //会出现选择通道一直没有打开事件，死循环中
        channel.configureBlocking(false);
        /**
         * channel.connect(new InetSocketAddress("localhost",8088)); 这段代码必须写在
         * channel.configureBlocking(false); 后面
         * **/
        channel.connect(new InetSocketAddress("localhost",8088)); //放到该处执行就好了
        Selector selector = Selector.open();
        channel.register(selector, SelectionKey.OP_CONNECT);
        boolean isRun = true;
        while (isRun){
            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            System.out.println("selectKeys : " + selectionKeys.size());
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            System.out.println("iterator hasNext ? : " + iterator.hasNext());
            while (iterator.hasNext()){
                SelectionKey key = iterator.next();
                if (key.isConnectable()){
                    System.out.println("client isConnectable!" + " channel is finishConnect ? " + channel.finishConnect());
                    while (!channel.finishConnect()){
                        System.out.println("!SocketChannel.finishConnect()");
                    }
                    SocketChannel socketChannel = (SocketChannel) key.channel();
                    socketChannel.close();
                }
                iterator.remove();
            }
        }
        channel.close();
    }

}
