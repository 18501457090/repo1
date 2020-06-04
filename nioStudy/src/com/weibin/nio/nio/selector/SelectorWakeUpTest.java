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
public class SelectorWakeUpTest {

    private static Selector selector;

    public static void main(String[] args) throws IOException {
        new Thread(()->{
            try {
                Thread.sleep(2000);
                selector.wakeup();
                Set<SelectionKey> keys = selector.keys();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                System.out.println("第二次执行wakeup()方法之后的selector信息：");
                System.out.println("keys : " + keys.size());
                System.out.println("selectionKeys : " + selectionKeys.size());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        ServerSocketChannel open = ServerSocketChannel.open();
        open.bind(new InetSocketAddress("localhost",8088));
        open.configureBlocking(false);
        selector = Selector.open();
        open.register(selector,SelectionKey.OP_ACCEPT);
        selector.wakeup();
        selector.select();
        System.out.println("第一次选择不会阻塞,因为先执行了wakeup");
        selector.select();
        Set<SelectionKey> selectionKeys = selector.selectedKeys();
        Iterator<SelectionKey> iterator = selectionKeys.iterator();
        while (iterator.hasNext()){
            SelectionKey next = iterator.next();
            if (next.isReadable()){
                ServerSocketChannel channel = (ServerSocketChannel) next.channel();
                SocketChannel accept = channel.accept();
                accept.close();
            }
            iterator.remove();
        }
        open.close();
        System.out.println("main End!!!");
    }

}
