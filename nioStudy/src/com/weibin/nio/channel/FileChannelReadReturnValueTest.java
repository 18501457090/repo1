package com.weibin.nio.channel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelReadReturnValueTest {
    static FileInputStream in;
    static FileChannel channel;
    final static public void main(String[] args) throws IOException {
        in = new FileInputStream("D:\\Channel\\Data\\read\\b.txt");
        channel = in.getChannel();
        ByteBuffer allocate1 = ByteBuffer.allocate(2);
        ByteBuffer allocate2 = ByteBuffer.allocate(2);
        ByteBuffer[] buffers = new ByteBuffer[]{allocate1,allocate2};
        long read = channel.read(buffers, 0, 2);
        System.out.println("A read: " + read);//取得四个字节
        allocate1.clear();
        allocate2.clear();
        read = channel.read(buffers, 0, 2);//取得四个字节
        System.out.println("B read : " + read);
        allocate1.clear();
        allocate2.clear();
        read = channel.read(buffers, 0, 2);//-1
        System.out.println("C read : " + read);
        allocate1.clear();
        allocate2.clear();
        channel.close();
        in.close();

    }



}
