package com.weibin.nio.nio.selectionkey;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import	java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/15
 **/
public class SelectionkeyIsWriteableClientTest {

    public static void main(String[] args) throws IOException {
        SocketChannel channel = SocketChannel.open();
        channel.configureBlocking(false);
        channel.connect(new InetSocketAddress("localhost",8088));
        Selector open = Selector.open();
        channel.register(open, SelectionKey.OP_CONNECT);
        boolean isRun = true;
        while (isRun){
            open.select();
            Set<SelectionKey> selectionKeys = open.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()){
                SelectionKey key = iterator.next();
                if (key.isConnectable()){
                    System.out.println("client isConnectable!");
                    if (channel.isConnectionPending()){
                        while (!channel.finishConnect()){}
                        channel.register(open,SelectionKey.OP_WRITE);
                    }
                }
                if (key.isWritable()){
                    System.out.println("client begin write data");
                    channel.write(ByteBuffer.wrap("send testData to server,hello!".getBytes()));
                    channel.close();
                    break;
                }
            }
        }

    }

}
