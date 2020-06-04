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
public class AsynchronousServerSocketChannelTest_3 {

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        AsynchronousServerSocketChannel serverSocketChannel = AsynchronousServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress("localhost",8088));
        Future<AsynchronousSocketChannel> channelFuture = serverSocketChannel.accept();
        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        AsynchronousSocketChannel socketChannel = channelFuture.get();
        Future<Integer> read1 = socketChannel.read(byteBuffer);
        Future<Integer> read2 = socketChannel.read(byteBuffer);
    }

}
