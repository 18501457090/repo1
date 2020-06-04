package com.weibin.nio.nio.selector;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import	java.nio.channels.ServerSocketChannel;
import java.sql.Struct;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/14
 **/
public class SelectorCloseTest {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel server = ServerSocketChannel.open();
        server.bind(new InetSocketAddress("localhost",8088));
        server.configureBlocking(false);
        Selector selector = Selector.open();
        SelectionKey selectionKey = server.register(selector, SelectionKey.OP_ACCEPT);
        new Thread(()->{
            try {
                Thread.sleep(2000);
                selector.close();
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        }).start();
        while (true){
            System.out.println("begin : " + System.currentTimeMillis());
            int select = selector.select();
            System.out.println("end : " + System.currentTimeMillis());
        }
    }

}
