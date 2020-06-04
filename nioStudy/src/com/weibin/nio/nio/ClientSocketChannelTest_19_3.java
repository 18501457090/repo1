package com.weibin.nio.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/11
 **/
public class ClientSocketChannelTest_19_3 {

    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        System.out.println("before socketChannel isPending ? " + socketChannel.isConnectionPending());
        socketChannel.connect(new InetSocketAddress("localhost",8088));
        // 输出false是因为这是阻塞操作,连接操作已经完成了。所以没有正在建立连接
        System.out.println("after socketChannel isPending ? " + socketChannel.isConnectionPending());
        socketChannel.close();
    }

}
