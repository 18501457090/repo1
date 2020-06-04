package com.weibin.nio.channel.lock;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2019/12/29
 **/
public class FileChannelLockTest_1 {

    public static void main(String[] args) throws Exception {
        RandomAccessFile file = new RandomAccessFile("D:\\Channel\\Data\\lock\\b.txt","rw");
        FileChannel channel = file.getChannel();
        channel.lock(0,Long.MAX_VALUE,true);
        Thread.sleep(Integer.MAX_VALUE);
    }

}
