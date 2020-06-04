package com.weibin.nio.channel.lock;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Date;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2019/12/29
 **/
public class FileChannelLockTest_8 {

    public static void main(String[] args) throws Exception {
        RandomAccessFile file = new RandomAccessFile("D:\\Channel\\Data\\lock\\d.txt","rw");
        FileChannel channel = file.getChannel();
        System.out.println("B 获取独占锁开始,当前时间为：" + new Date().toLocaleString());
        FileLock lock = channel.lock(0, 100, false);
        channel.lock();
        System.out.println("B 获取到独占锁,当前时间为：" + new Date().toLocaleString());
        channel.close();
        file.close();

    }

}
