package com.weibin.aio;
import java.io.IOException;
import java.nio.ByteBuffer;
import	java.nio.file.StandardOpenOption;

import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/17
 **/
public class AsynchronousFileChannelReadTest_1 {

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        Path path = Paths.get("D:\\Channel\\Data\\AsynchonousFileChannel\\1.txt");
        AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(path,
                StandardOpenOption.READ, StandardOpenOption.WRITE);
        ByteBuffer allocate = ByteBuffer.allocate(200);
        Future<Integer> read = fileChannel.read(allocate, 0);
        Integer integer = read.get();
        int count = 0;
        while (integer != -1){
            count += integer;
            System.out.println(new String(allocate.array(),0,allocate.position()));
            allocate.flip();
            read = fileChannel.read(allocate, count);
            integer = read.get();
        }

    }

}
