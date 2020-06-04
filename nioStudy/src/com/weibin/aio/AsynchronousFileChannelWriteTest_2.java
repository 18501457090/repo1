package com.weibin.aio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/17
 **/
public class AsynchronousFileChannelWriteTest_2 {

    public static void main(String[] args) throws IOException, InterruptedException {
        Path path = Paths.get("D:\\Channel\\Data\\AsynchonousFileChannel\\write_2.txt");
        AsynchronousFileChannel asynchronousFileChannel = AsynchronousFileChannel.open(path,
                StandardOpenOption.WRITE, StandardOpenOption.CREATE);
        ByteBuffer byteBuffer = ByteBuffer.wrap("testData".getBytes());
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        asynchronousFileChannel.write(byteBuffer, asynchronousFileChannel.size(), "附加数据",
                new CompletionHandler<Integer, String>() {
            @Override
            public void completed(Integer result, String attachment) {
                atomicBoolean.compareAndSet(false,true);
                System.out.println("result : " + result + "  attachment : " + attachment);
            }

            @Override
            public void failed(Throwable exc, String attachment) {
                System.out.println("failed() attachment : " + attachment + "  exc : " + exc);
            }
        });
        while (!atomicBoolean.get());
        System.out.println("flag : " + atomicBoolean.get());
        asynchronousFileChannel.close();


    }

}
