package com.weibin.aio.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/17
 **/
public class AsynchronousServerSocketChannelTest_1 {

    public static void main(String[] args) throws IOException {
        AsynchronousServerSocketChannel serverSocketChannel = AsynchronousServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress("localhost",8088),90);
        serverSocketChannel.accept(null, new CompletionHandler<AsynchronousSocketChannel, Void>() {
            @Override
            public void completed(AsynchronousSocketChannel result, Void attachment) {
                serverSocketChannel.accept(null,this);
                System.out.println("handle ThreadName : " + Thread.currentThread().getName());
                ByteBuffer allocate = ByteBuffer.allocate(512);
                Future<Integer> read = result.read(allocate);
                try {
                    Thread.sleep(4000);
                    System.out.println(new String(allocate.array(),0,read.get()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void failed(Throwable exc, Void attachment) {

            }
        });
        while (true);

    }

}
