package com.weibin.nio.nio;
import	java.io.RandomAccessFile;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/12
 **/
public class TransferToMethodTest_1 {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        SocketChannel socketChannel = null;
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress("localhost",8088));
        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        boolean isRun = true;
        while (isRun){
            selector.select();
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = keys.iterator();
            while (iterator.hasNext()){
                SelectionKey next = iterator.next();
                iterator.remove();
                if (next.isAcceptable()){
                    socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector,SelectionKey.OP_WRITE);
                }
                if (next.isWritable()){
                    RandomAccessFile raf = new RandomAccessFile("D:\\Channel\\Data\\write\\TestData_1.txt","rw");
                    System.out.println("fileLength : " + raf.length());
                    FileChannel channel = raf.getChannel();
                    channel.transferTo(0,raf.length(),socketChannel);
                    channel.close();
                    raf.close();
                    socketChannel.close();
                }
            }
        }
        serverSocketChannel.close();
    }


}
