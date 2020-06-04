package com.weibin.nio.nio.selectionkey;
import java.net.Socket;
import java.nio.channels.*;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/15
 **/
    public class SelectionKeyIsAcceptableTest {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress("localhost",8088));
        serverSocketChannel.configureBlocking(false);
        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        boolean isRun = true;
        while (isRun){
            int select = selector.select();
            Set<SelectionKey> set = selector.selectedKeys();
            Iterator<SelectionKey> iterator = set.iterator();
            while (iterator.hasNext()){
                SelectionKey next = iterator.next();
                ServerSocketChannel channel = (ServerSocketChannel) next.channel();

                SocketChannel socket = null;
                if (next.isAcceptable()){
                    socket = channel.accept();
                    System.out.println("socket isAcceptable!");
                }
                if (Objects.nonNull(socket)){
                    socket.close();
                }
                iterator.remove();
            }
        }
        serverSocketChannel.close();
    }

}
