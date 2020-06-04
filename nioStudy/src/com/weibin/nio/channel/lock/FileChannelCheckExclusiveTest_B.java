package com.weibin.nio.channel.lock;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2019/12/29
 **/
public class FileChannelCheckExclusiveTest_B {

    public static void main(String[] args) throws Exception {
        RandomAccessFile raf = new RandomAccessFile("D:\\Channel\\Data\\lock\\a.txt","rw");
        FileChannel channel = raf.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(10);
        channel.read(buffer);
        buffer.rewind();
        for (int i = 0; i < buffer.limit(); i++){
            System.out.print((char) buffer.get(i));
        }

    }

}
