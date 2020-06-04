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
public class AsynchronousFileLockAreaTestA {

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        Path path = Paths.get("D:\\Channel\\Data\\AsynchonousFileChannel\\1.txt");
        AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE);
        System.out.println("A begin lock : " + new Date().toLocaleString());
        Future<FileLock> lock = fileChannel.lock(0, 2, false);
        FileLock fileLock = lock.get();
        Thread.sleep(5000);
        System.out.println("A begin end : " + new Date().toLocaleString());
        fileLock.release();
        fileChannel.close();
    }

}
