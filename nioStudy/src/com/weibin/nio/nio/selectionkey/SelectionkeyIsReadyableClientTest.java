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
public class SelectionkeyIsReadyableClientTest {

    public static void main(String[] args) throws IOException {
        SocketChannel channel = SocketChannel.open();
        channel.configureBlocking(false);
        Selector selector = Selector.open();
        channel.register(selector,SelectionKey.OP_CONNECT);
        // 因为通道是非阻塞模式通道，所以不会立即发起连接，而是在随后的某个时间才发起连接
        channel.connect(new InetSocketAddress("localhost",8088));
        selector.select();
        Set<SelectionKey> selectionKeys = selector.selectedKeys();
        Iterator<SelectionKey> iterator = selectionKeys.iterator();
        while (iterator.hasNext()){
            SelectionKey key = iterator.next();
            if (key.isConnectable()){
                System.out.println("isConnectPending ? " + channel.isConnectionPending());
                // 如果此通道处于非阻塞模式,那么当连接过程尚未完成时，此方法将返回false
                while (!channel.finishConnect()){}
                System.out.println("client isConnectable!");
                SocketChannel channel1 = (SocketChannel) key.channel();
                channel1.write(ByteBuffer.wrap("send data to server".getBytes()));
                channel1.close();
            }
        }

    }

}
