package com.weibin.aio.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/18
 **/
public class AsynchronousSocketChannelTest_4 {

    public static void main(String[] args) throws IOException, InterruptedException {
        AsynchronousSocketChannel socketChannel = AsynchronousSocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost", 8088), null, new CompletionHandler<Void, Object>() {
            @Override
            public void completed(Void result, Object attachment) {
                try {
                ByteBuffer byteBuffer = ByteBuffer.allocate(Integer.MAX_VALUE / 100);
                for (int i = 0 ; i < Integer.MAX_VALUE / 100 - 3; i++){
                    byteBuffer.put("1".getBytes());
                }
                byteBuffer.put("end" .getBytes());
                byteBuffer.flip();
                int writeNum = 0;
                while (writeNum < byteBuffer.limit()){
                    Future<Integer> future = socketChannel.write(byteBuffer);
                    Integer count = future.get();
                    writeNum += count;
                }
                System.out.println("客户端共写入了：" + writeNum);
                socketChannel.close();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void failed(Throwable exc, Object attachment) {
                exc.printStackTrace();
                System.out.println("exc : " + exc);
            }
        });
        Thread.sleep(10000);
    }

}
