package com.weibin.nio.provider;
import java.io.IOException;
import java.net.StandardProtocolFamily;
import java.nio.channels.*;
import java.nio.channels.spi.AbstractSelector;
import	java.nio.channels.spi.SelectorProvider;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/15
 **/
public class SocketProviderTest {

    public static void main(String[] args) throws IOException {
        SelectorProvider provider = SelectorProvider.provider();
        System.out.println("provider : " + provider.getClass().getName());
        AbstractSelector abstractSelector = provider.openSelector();
        DatagramChannel datagramChannel = provider.openDatagramChannel();
        DatagramChannel datagramChannel1 = provider.openDatagramChannel(StandardProtocolFamily.INET);
        DatagramChannel datagramChannel2 = provider.openDatagramChannel(StandardProtocolFamily.INET6);
        Pipe pipe = provider.openPipe();
        ServerSocketChannel serverSocketChannel1 = provider.openServerSocketChannel();
        SocketChannel socketChannel = provider.openSocketChannel();
        Channel channel = provider.inheritedChannel();
        Channel channel1 = System.inheritedChannel();
        System.out.println("selector : " + abstractSelector.getClass().getName());
        System.out.println("datagramChannel : " + datagramChannel.getClass().getName());
        System.out.println("datagramChannel1 : " + datagramChannel1.getClass().getName());
        System.out.println("datagramChannel2 : " + datagramChannel2.getClass().getName());
        System.out.println("pipe : " + pipe.getClass().getName());
        System.out.println("serverSocketChannel1 : " + serverSocketChannel1.getClass().getName());
        System.out.println("socketChannel : " + socketChannel.getClass().getName());
        System.out.println("channel : " + channel);
        System.out.println("channel1 : " + channel1);


    }

}
