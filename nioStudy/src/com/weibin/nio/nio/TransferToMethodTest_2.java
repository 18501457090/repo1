package com.weibin.nio.nio;
import	java.nio.ByteBuffer;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/12
 **/
public class TransferToMethodTest_2 {

    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        socketChannel.connect(new InetSocketAddress("localhost",8088));
        Selector selector = Selector.open();
        socketChannel.register(selector, SelectionKey.OP_CONNECT);
        boolean isRun = true;
        while (isRun){
            System.out.println("begin selector");
            if (socketChannel.isOpen()){
                selector.select();
                System.out.println(" end selector");
                Set<SelectionKey> set = selector.selectedKeys();
                Iterator<SelectionKey> iterator = set.iterator();
                while (iterator.hasNext()){
                    SelectionKey next = iterator.next();
                    iterator.remove();
                    if (next.isConnectable()){
                        while (!socketChannel.finishConnect()){}
                        socketChannel.register(selector,SelectionKey.OP_READ);
                    }
                    if (next.isReadable()){
                        ByteBuffer buffer = ByteBuffer.allocate(5000);
                        int read = socketChannel.read(buffer);
                        buffer.flip();
                        long count = 0;
                        while (read != -1){
                            count += read;
                            read = socketChannel.read(buffer);
                            System.out.println("count : " + count + " read : " + read);
                            buffer.clear();
                        }
                        System.out.println("读取结束 ");
                        socketChannel.close();
                    }
                }
            } else{
                break;
            }
        }
    }

}
