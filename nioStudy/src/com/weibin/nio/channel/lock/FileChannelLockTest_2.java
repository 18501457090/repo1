package com.weibin.nio.channel.lock;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2019/12/29
 **/
public class FileChannelLockTest_2 {

    public static void main(String[] args) throws Exception {
        RandomAccessFile file = new RandomAccessFile("D:\\Channel\\Data\\lock\\b.txt","rw");
        FileChannel channel = file.getChannel();
        channel.lock(0,Long.MAX_VALUE,true);
        System.out.println("共享锁是允许其他进程获取的,非互斥的");
    }

}
