package com.weibin.aio.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.TimeUnit;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/18
 **/
public class AsynchronousServerSocketChannelTest_5 {

    public static void main(String[] args) throws IOException {
        AsynchronousServerSocketChannel socketChannel = AsynchronousServerSocketChannel.open();
        socketChannel.bind(new InetSocketAddress("localhost",8088));
        socketChannel.accept(null, new CompletionHandler<AsynchronousSocketChannel, Void>() {
            @Override
            public void completed(AsynchronousSocketChannel ch, Void attachment) {
                socketChannel.accept(null,this); // 继续下一个accept操作
                ByteBuffer byteBuffer = ByteBuffer.allocate(Integer.MAX_VALUE / 100);
                ch.read(byteBuffer, 10, TimeUnit.SECONDS, null, new CompletionHandler<Integer, Void>() {
                    @Override
                    public void completed(Integer result, Void attachment) {
                        try {
                            if (result == -1){
                                System.out.println("客户端没有传输数据就执行close了,到流末尾了");
                            }
                            if (result == byteBuffer.limit()){
                                System.out.println("服务端获得客户端完整数据 " + result);
                            }
                            ch.close();
                            System.out.println("服务端close");
                        } catch (Exception e){
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void failed(Throwable exc, Void attachment) {
                        exc.printStackTrace();
                    }
                });
            }

            @Override
            public void failed(Throwable exc, Void attachment) {
                exc.printStackTrace();
            }
        });
        while (true);
    }

}
