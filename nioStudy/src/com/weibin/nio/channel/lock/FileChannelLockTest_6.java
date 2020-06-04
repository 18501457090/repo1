package com.weibin.nio.channel.lock;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.Date;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2019/12/29
 **/
public class FileChannelLockTest_6 {

    public static void main(String[] args) throws Exception {
        // 验证独占锁与共享锁之间是互斥关系
        RandomAccessFile file = new RandomAccessFile("D:\\Channel\\Data\\lock\\c.txt","rw");
        FileChannel channel = file.getChannel();
        System.out.println("获取共享锁开始,当前时间为：" + new Date().toLocaleString());
        channel.lock(0,100,true);
        System.out.println("获取共享锁结束,当前时间为：" + new Date().toLocaleString());
    }

}
