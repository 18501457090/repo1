package com.weibin.nio.nio.selectionkey;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import	java.nio.channels.SelectionKey;
import java.io.IOException;
import java.nio.channels.Selector;
import	java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/15
 **/
public class SelectionReadyOpsClientTest {

    public static void main(String[] args) throws IOException {
        SocketChannel channel = SocketChannel.open();
        channel.configureBlocking(false);
        Selector selector = Selector.open();
        channel.register(selector,SelectionKey.OP_CONNECT | SelectionKey.OP_READ | SelectionKey.OP_WRITE);
        channel.connect(new InetSocketAddress("localhost",8088));

        boolean isRunning = true;
        while (isRunning){
            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()){
                SelectionKey key = iterator.next();
                System.out.println("key.readyOps : " + key.readyOps() + " accept : " + SelectionKey.OP_ACCEPT + "  " +
                        "connect : " + SelectionKey.OP_CONNECT + " read : " + SelectionKey.OP_READ  + "  write : " + SelectionKey.OP_WRITE);
                if (key.isConnectable()){
                    System.out.println("client isConnectable OP_ACCEPT : " + (SelectionKey.OP_ACCEPT & ~key.readyOps()));
                    System.out.println("client isConnectable OP_CONNECT : " + (SelectionKey.OP_CONNECT & ~key.readyOps()));
                    System.out.println("client isConnectable OP_WRITE : " + (SelectionKey.OP_WRITE & ~key.readyOps()));
                    System.out.println("client isConnectable OP_READ : " + (SelectionKey.OP_READ & ~key.readyOps()));
                    if (channel.isConnectionPending()){
                        while (!channel.finishConnect());
                        channel.register(selector, SelectionKey.OP_WRITE,"use attachment send data to server");
                    }
                }
                if (key.isWritable()){
                    System.out.println("client isWritable OP_ACCEPT : " + (SelectionKey.OP_ACCEPT & ~key.readyOps()));
                    System.out.println("client isWritable OP_CONNECT : " + (SelectionKey.OP_CONNECT & ~key.readyOps()));
                    System.out.println("client isWritable OP_WRITE : " + (SelectionKey.OP_WRITE & ~key.readyOps()));
                    System.out.println("client isWritable OP_READ : " + (SelectionKey.OP_READ & ~key.readyOps()));
                    ByteBuffer byteBuffer = ByteBuffer.wrap(String.valueOf(key.attachment()).getBytes());
                    channel.write(byteBuffer);
                    channel.close();
                    key.cancel();
                }
            }

        }

    }

}
