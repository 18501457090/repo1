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
public class SelectorTimeOutTest {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress("localhost",8088));
        serverSocketChannel.configureBlocking(false);
        Selector selector = Selector.open();
        SelectionKey register = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        boolean isRun = true;
        while (isRun){
            System.out.println(System.currentTimeMillis());
            int select = selector.select(5000);//阻塞5000毫秒后会继续执行下方的代码
            System.out.println("selectCount : " + select);
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()){
                SelectionKey next = iterator.next();
                if (next.isReadable()){
                    System.out.println("read准备就绪！！！");
                    ServerSocketChannel serverSocketChannel1 = (ServerSocketChannel) next.channel();
                    SocketChannel accept = serverSocketChannel1.accept();
                    accept.close();
                }
                iterator.remove();
            }
            serverSocketChannel.close();
        }
    }

}
