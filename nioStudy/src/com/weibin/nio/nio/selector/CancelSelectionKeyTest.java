package com.weibin.nio.nio.selector;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/13
 **/
public class CancelSelectionKeyTest {

    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress("localhost",8088));
        serverSocketChannel.configureBlocking(false);
        ServerSocketChannel serverSocketChannel2 = ServerSocketChannel.open();
        serverSocketChannel2.bind(new InetSocketAddress("localhost",9099));
        serverSocketChannel2.configureBlocking(false);
        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT );
        serverSocketChannel2.register(selector, SelectionKey.OP_ACCEPT);
        new Thread(()->{
            try {
                Thread.sleep(10000);
                Set<SelectionKey> keys = selector.keys();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                System.out.println("---------------------------------");
                System.out.println("select()方法执行第二次后的信息：");
                System.out.println("keys.size() : " + keys.size());
                System.out.println("selectionKeys.size() : " + selectionKeys.size());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        Thread.sleep(2000);
        while (true){
            int select = selector.select();
            Set<SelectionKey> selectionKeys = selector.keys();
            Set<SelectionKey> selectionKeys1 = selector.selectedKeys();
            System.out.println("取消之前的信息：");
            System.out.println("Keys ： " + selectionKeys.size());
            System.out.println("selectionKeys ： " + selectionKeys1.size());
            System.out.println("---------------------------------");
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()){
                SelectionKey next = iterator.next();
                if (next.isAcceptable()){
                    ServerSocketChannel serverSocketChannel1 = (ServerSocketChannel) next.channel();
                    ServerSocket socket = serverSocketChannel1.socket();
                    Socket accept = socket.accept();
                    byte[] bytes = new byte[1000];
                    InputStream in = accept.getInputStream();
                    int read = in.read(bytes);
                    while (read != -1){
                        System.out.println(new String(bytes,0,read));
                        read = in.read(bytes);
                    }
                    in.close();
                    accept.close();
                    if (socket.getLocalPort() == 8088){
                        next.cancel();
                        System.out.println("取消之后的信息：");
                        System.out.println("select ：" + select);
                        System.out.println("selectionKeys ： " + selectionKeys.size());
                    }
                }
            }
        }
        //serverSocketChannel.close();
        //serverSocketChannel2.close();
    }

}
