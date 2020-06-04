package com.weibin.aio;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/17
 **/
public class AsynchronousFileChannelWriteTest_1 {

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        Path path = Paths.get("D:\\Channel\\Data\\AsynchonousFileChannel\\write.txt");
        AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(path,
                StandardOpenOption.WRITE, StandardOpenOption.CREATE);
        ByteBuffer byteBuffer = ByteBuffer.wrap("abcde".getBytes());
        System.out.println(fileChannel.size());
        Future<Integer> write = fileChannel.write(byteBuffer, fileChannel.size());
        final Integer integer = write.get();
        fileChannel.close();



    }

}
