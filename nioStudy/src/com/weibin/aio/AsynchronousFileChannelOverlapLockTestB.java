package com.weibin.aio;

import java.io.IOException;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.FileLock;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/16
 **/
public class AsynchronousFileChannelOverlapLockTestB {

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        Path path = Paths.get("D:\\Channel\\Data\\AsynchonousFileChannel\\1.txt");
        AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE);
        Future<FileLock> future = fileChannel.lock(1, 5, false);
        final FileLock fileLock = future.get();
        System.out.println("B getLock time : " + new Date().toLocaleString());
        Thread.sleep(2000);
        fileLock.release();
        System.out.println("B releaseLock time : " + new Date().toLocaleString());
        fileChannel.close();
    }

}
