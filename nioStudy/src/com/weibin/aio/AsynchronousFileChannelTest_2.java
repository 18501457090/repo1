package com.weibin.aio;

import java.io.IOException;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.channels.FileLock;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/16
 **/
public class AsynchronousFileChannelTest_2 {

    public static void main(String[] args) throws IOException, InterruptedException {
        Path path = Paths.get("D:\\Channel\\Data\\AsynchonousFileChannel\\1.txt");
        AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE);
        System.out.println("begin time : " + System.currentTimeMillis());
        fileChannel.lock(0, 3, false, "test data", new CompletionHandler<FileLock, String>() {
            @Override
            public void completed(FileLock result, String attachment) {
                System.out.println("attachment : " + attachment);
                try {
                    result.release();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void failed(Throwable exc, String attachment) {
                System.out.println("cause : " + exc.getMessage());
            }
        });
        System.out.println("end : " + System.currentTimeMillis());
        //Thread.sleep(1000);
        fileChannel.close();
    }

}
