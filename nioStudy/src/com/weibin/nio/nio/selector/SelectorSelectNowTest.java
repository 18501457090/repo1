package com.weibin.nio.nio.selector;

import com.sun.org.apache.bcel.internal.generic.Select;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/13
 **/
public class SelectorSelectNowTest {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel open = ServerSocketChannel.open();
        open.bind(new InetSocketAddress("localhost",8088),80);
        open.configureBlocking(false);
        Selector open1 = Selector.open();
        open.register(open1, SelectionKey.OP_ACCEPT);
        while (true){
            System.out.println("开始选择就绪通道" + System.currentTimeMillis());
            int i = open1.selectNow();
            System.out.println("未阻塞，立即返回,已就绪的通道数目为：" + i + "  当前时间为：" + System.currentTimeMillis());
        }
    }

}
