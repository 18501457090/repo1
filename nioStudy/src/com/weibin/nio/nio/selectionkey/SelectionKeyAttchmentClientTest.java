package com.weibin.nio.nio.selectionkey;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import	java.nio.channels.Selector;
import java.io.IOException;
import java.net.InetSocketAddress;
import	java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/15
 **/
public class SelectionKeyAttchmentClientTest {

    public static void main(String[] args) throws IOException {
        SocketChannel channel = SocketChannel.open();
        channel.configureBlocking(false);
        channel.connect(new InetSocketAddress("localhost",8088));
        Selector selector = Selector.open();
        channel.register(selector, SelectionKey.OP_CONNECT);
        boolean isRunning = true;
        while (isRunning){
            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()){
                SelectionKey key = iterator.next();
                if (key.isConnectable()){
                    System.out.println("client isConnectable !");
                    if (channel.isConnectionPending()){
                        while (!channel.finishConnect());
                    }
                    channel.register(selector,SelectionKey.OP_WRITE);
                    key.attach("use attachment register!");
                }
                if (key.isWritable()){
                    System.out.println("client isWritable!");
                    channel.write(ByteBuffer.wrap(String.valueOf(key.attachment()).getBytes()));
                    channel.close();
                }
            }
        }

    }

}
