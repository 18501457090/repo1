package com.weibin.nio.nio.selector;
import com.weibin.nio.nio.Client;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import	java.net.InetSocketAddress;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/14
 **/
public class SelectorThreadTest {

    static Thread mainThread = Thread.currentThread();

    public static void main(String[] args) throws IOException {
         ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
         serverSocketChannel.bind(new InetSocketAddress("localhost",8088));
         serverSocketChannel.configureBlocking(false);
        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        new Thread(()->{
            try {
                Thread.sleep(1000);
                mainThread.interrupt();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        while (true){
            System.out.println("begin：" + System.currentTimeMillis());
            selector.select();
            boolean interrupted = mainThread.isInterrupted();
            if (interrupted){
                System.out.println(mainThread.getName() + " 线程收到中断通知,结束运行：" + System.currentTimeMillis());
                break;
            }
        }
    }
    
}
