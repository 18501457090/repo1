package com.weibin.aio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/17
 **/
public class AsynchronousFileChannelLoopWriteTest_1 {

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        Path path = Paths.get("D:\\Channel\\Data\\AsynchonousFileChannel\\loopWrite.txt");
        AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(path,
                StandardOpenOption.WRITE, StandardOpenOption.CREATE);
        for (int i = 0;i < 100;i++){
            String str = (UUID.randomUUID() + new Date().toLocaleString()) + "\r\n";
            ByteBuffer byteBuffer = ByteBuffer.wrap(str.getBytes());
            System.out.println("fileChannel.size() : " + fileChannel.size());
            Future<Integer> write = fileChannel.write(byteBuffer, fileChannel.size());
            Integer integer = write.get();
            System.out.println("integer : " + integer);
        }
        fileChannel.close();
    }

}
