package com.weibin.nio.channel.lock;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2019/12/29
 **/
public class FileChannelCheckSharedTest_2 {

    public static void main(String[] args) throws Exception {
        RandomAccessFile raf = new RandomAccessFile("D:\\Channel\\Data\\lock\\a.txt","rw");
        FileChannel channel = raf.getChannel();
        channel.write(ByteBuffer.wrap("123456".getBytes()));
        channel.close();
        raf.close();
    }

}
