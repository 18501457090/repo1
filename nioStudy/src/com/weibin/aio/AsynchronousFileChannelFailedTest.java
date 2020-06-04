package com.weibin.aio;
import	java.nio.channels.CompletionHandler;

import java.io.IOException;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.FileLock;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/16
 **/
public class AsynchronousFileChannelFailedTest {

    public static void main(String[] args) throws IOException, InterruptedException {
        Path path = Paths.get("D:\\Channel\\Data\\AsynchonousFileChannel\\1.txt");
        AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE);
        fileChannel.close();
        fileChannel.lock("test data!", new CompletionHandler<FileLock, String>() {
            @Override
            public void completed(FileLock result, String attachment) {
                try {
                    result.release();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void failed(Throwable exc, String attachment) {
                System.out.println("附件内容为：" + attachment);
                System.out.println(exc.getClass().getName());
            }
        });
        Thread.sleep(1000);
    }

}
