package com.weibin.nio.channel;

import java.nio.ByteBuffer;
import java.net.InetSocketAddress;
import java.nio.channels.*;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/3/24
 **/
public class MyService {

    private static Selector selector = null;

    private static final ThreadLocal tl = new ThreadLocal();

    private static final Object lock = new Object();

    private volatile static boolean isRun = false;

    public static void main(String[] args) {
        MyService.open();
    }

    public static void open() {
        synchronized (lock) {
            if (!isRun) {
                isRun = true;
                initSelector();
                initServerSocketChannel();
            }
        }
    }

    public static void initSelector() {
        try {
            selector = Selector.open();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initServerSocketChannel() {
        try {
            ServerSocketChannel serverChannel = ServerSocketChannel.open();
            serverChannel.isBlocking();
            serverChannel.bind(new InetSocketAddress("localhost", 8088));
            serverChannel.configureBlocking(false);
            serverChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void run() {
        while (isRun) {
            try {
                selector.select();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                SelectionKey key = null;
                while (iterator.hasNext()) {
                    key = iterator.next();
                    iterator.remove();
                    handler(key);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void handler(SelectionKey key) {
        if (key.isAcceptable()) {
            handlerAcceptable(key);
        }
        if (key.isReadable()) {
            handlerReadable(key);
        }

    }

    public static void handlerReadable(SelectionKey key) {
        SocketChannel channel = (SocketChannel) key.channel();
        ByteBuffer buffer = ByteBuffer.allocate(512);
        int read = 0;
        try {
            read = channel.read(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (read > 0) {
            buffer.flip();
            System.out.println("客户端数据为：" + new String(buffer.array()));
        }
    }

    public static void handlerAcceptable(SelectionKey key) {
        ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
        try {
            SocketChannel accept = ssc.accept();
            accept.configureBlocking(false);
            accept.register(selector, SelectionKey.OP_READ);
            // 将key对应Channel设置为准备接受其他请求
            key.interestOps(SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void close() {
        synchronized (lock) {
            if (isRun) {
                isRun = false;
            }
        }
    }


}
