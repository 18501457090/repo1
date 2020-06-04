package com.weibin.aio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/17
 **/
public class AsynchronousFileChannelReadTest_2 {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("D:\\Channel\\Data\\AsynchonousFileChannel\\1.txt");
        AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(path, StandardOpenOption.READ);
        ByteBuffer byteBuffer = ByteBuffer.allocate(100);
        fileChannel.read(byteBuffer, 0, "test data", new CompletionHandler<Integer, String>() {
            @Override
            public void completed(Integer result, String attachment) {
                System.out.println("result : " + result + " attachment : " + attachment);
            }

            @Override
            public void failed(Throwable exc, String attachment) {
                System.out.println("failed attachment : " + attachment + " exc : " + exc.getMessage());
            }
        });
        fileChannel.close();
        byte[] array = byteBuffer.array();
        System.out.println("position : " + byteBuffer.position());
        for (int i = 0 ; i < byteBuffer.position() ; i++){
            System.out.print((char) array[i]);
        }
    }

}
