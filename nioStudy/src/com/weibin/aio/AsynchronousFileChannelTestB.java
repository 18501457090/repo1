package com.weibin.aio;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.io.IOException;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.FileLock;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/16
 **/
public class AsynchronousFileChannelTestB {

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        Path path = Paths.get("D:\\Channel\\Data\\AsynchonousFileChannel\\1.txt");
        AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE);
        System.out.println("B lock begin : " +System.currentTimeMillis());
        Future<FileLock> lock = fileChannel.lock();
        System.out.println("B lock end : " + System.currentTimeMillis());
        FileLock fileLock = lock.get();
        System.out.println("B getLock : " + System.currentTimeMillis());
        fileLock.release();
        fileChannel.close();

    }

}
