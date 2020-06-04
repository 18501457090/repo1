package com.weibin.nio.nio.selector;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import	java.nio.channels.ServerSocketChannel;
import java.util.Date;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/12
 **/
public class SelectorTest_1 {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel server = ServerSocketChannel.open();
        server.bind(new InetSocketAddress("localhost",8088));
        server.configureBlocking(false);
        Selector selector = Selector.open();
        server.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("select start : " + new Date().toLocaleString());
        int select = selector.select();
        System.out.println("select end ！");
        System.out.println("select channel count : " + select + "  " + new Date().toLocaleString());
        server.close();
    }

}
