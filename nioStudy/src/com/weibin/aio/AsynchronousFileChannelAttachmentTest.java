package com.weibin.aio;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.channels.FileLock;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/16
 **/
public class AsynchronousFileChannelAttachmentTest {

    public static void main(String[] args) throws IOException, InterruptedException {
        Path path = Paths.get("D:\\Channel\\Data\\AsynchonousFileChannel\\1.txt");
        AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE);
        System.out.println("begin time : " + new Date().toLocaleString());
        fileChannel.lock("test data", new CompletionHandler<FileLock, String>() {
            @Override
            public void completed(FileLock result, String attachment) {
                System.out.println("attachment : " + attachment);
                try {
                    result.release();
                    fileChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void failed(Throwable exc, String attachment) {
                System.out.println("failed execute !!!");
                System.out.println("errorMessage : " + exc.getMessage());
            }
        });
        System.out.println("end time : " + new Date().toLocaleString());
        Thread.sleep(3000);
    }

}
