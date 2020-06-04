package com.weibin.nio.pipe;
import	java.util.concurrent.CountDownLatch;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/15
 **/
public class PipeTest {

    public static void main(String[] args) throws IOException, InterruptedException {
        Pipe pipe = Pipe.open();
        Pipe.SinkChannel sink = pipe.sink();
        Pipe.SourceChannel source = pipe.source();
        CountDownLatch latch = new CountDownLatch(2);
        new Thread(()->{
            try {
                for (int i = 0 ; i < 5;i++){
                    sink.write(ByteBuffer.wrap(("来自客户端A ：" + i + "\r\n").getBytes()));
                }
                latch.countDown();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                for (int i = 0 ; i < 5;i++){
                    sink.write(ByteBuffer.wrap(("来自客户端B ：" + i + "\r\n").getBytes()));
                }
                latch.countDown();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
        latch.await();
        sink.close();
        ByteBuffer allocate = ByteBuffer.allocate(1000);
        int read = source.read(allocate);
        while (read != -1){
            System.out.println(new String(allocate.array(),0,read));
            read = source.read(allocate);
        }
        source.close();
    }

}
