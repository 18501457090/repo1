package com.weibin.aio.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/18
 **/
public class AsynchronousServerSocketChannelTest_2 {

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        AsynchronousServerSocketChannel serverSocketChannel = AsynchronousServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress("localhost",8088));
        Future<AsynchronousSocketChannel> channelFuture = serverSocketChannel.accept();
        AsynchronousSocketChannel socketChannel = channelFuture.get();
        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        Future<Integer> read = socketChannel.read(byteBuffer);
        System.out.println(new String(byteBuffer.array(),0,read.get()));
        Thread.sleep(4000);
    }

}
