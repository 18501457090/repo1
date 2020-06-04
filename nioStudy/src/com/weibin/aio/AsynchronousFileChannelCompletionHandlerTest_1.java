package com.weibin.aio;
import java.io.IOException;
import java.nio.channels.CompletionHandler;
import java.nio.channels.FileLock;
import	java.nio.file.StandardOpenOption;

import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/17
 **/
public class AsynchronousFileChannelCompletionHandlerTest_1 {


    public static void main(String[] args) throws IOException, InterruptedException {
        Path path = Paths.get("D:\\Channel\\Data\\AsynchonousFileChannel\\1.txt");
        AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(path,
                StandardOpenOption.READ, StandardOpenOption.WRITE);
        System.out.println("A begin time : " + new Date().toLocaleString() + " currentThreadName : " +
                Thread.currentThread().getName());
        fileChannel.lock("test attchment data", new CompletionHandler<FileLock, String>() {
            @Override
            public void completed(FileLock result, String attachment) {
                try {
                    System.out.println("currentThreadName : " + Thread.currentThread().getName());
                    Thread.sleep(3000);
                    result.release();
                    System.out.println("release time : " + new Date().toLocaleString());
                } catch (InterruptedException | IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void failed(Throwable exc, String attachment) {
                System.out.println("attachment : " + attachment);
            }
        });
        System.out.println("A end time : " + new Date().toLocaleString());
        Thread.sleep(10000);
        fileChannel.close();

    }

}
