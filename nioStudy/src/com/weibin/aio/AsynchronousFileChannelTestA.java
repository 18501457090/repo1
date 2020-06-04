package com.weibin.aio;

import java.io.IOException;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.FileLock;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @Desc: 获取此通道文件的独占锁
 * @author: zwb
 * @Date: 2020/1/16
 **/
public class AsynchronousFileChannelTestA {

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        Path path = Paths.get("D:\\Channel\\Data\\AsynchonousFileChannel\\1.txt");
        AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE);
        Future<FileLock> future = fileChannel.lock();
        FileLock fileLock = future.get();
        System.out.println("A lock time : " + System.currentTimeMillis());
        Thread.sleep(4000);
        fileLock.release();
        System.out.println("B release lock time : " + System.currentTimeMillis());
        fileChannel.close();
    }

}
