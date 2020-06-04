package com.weibin.aio;
import java.io.IOException;
import java.nio.channels.FileLock;
import	java.nio.file.StandardOpenOption;

import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/16
 **/
public class AsynchronousFileChannelOverlapLockTestA {

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        Path path = Paths.get("D:\\Channel\\Data\\AsynchonousFileChannel\\1.txt");
        AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE);
        Future<FileLock> lockFuture = fileChannel.lock(0,3,false);
        FileLock fileLock = lockFuture.get();
        System.out.println("A getLock time : " + new Date().toLocaleString());
        Thread.sleep(5000);
        fileLock.release();
        System.out.println("A releaseLock time : " + new Date().toLocaleString());
        fileChannel.close();
    }

}
