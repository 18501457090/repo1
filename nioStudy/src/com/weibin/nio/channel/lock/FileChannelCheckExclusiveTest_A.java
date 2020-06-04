package com.weibin.nio.channel.lock;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2019/12/29
 **/
public class FileChannelCheckExclusiveTest_A {

    public static void main(String[] args) throws Exception {
        RandomAccessFile raf = new RandomAccessFile("D:\\Channel\\Data\\lock\\a.txt","rw");
        FileChannel channel = raf.getChannel();
        channel.lock(1,2,false);
        Thread.sleep(Integer.MAX_VALUE);
    }

}
