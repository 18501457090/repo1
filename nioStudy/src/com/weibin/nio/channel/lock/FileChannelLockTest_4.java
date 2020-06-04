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
public class FileChannelLockTest_4 {

    public static void main(String[] args) throws Exception {
        // 验证共享锁与独占锁之间是互斥关系
        RandomAccessFile file = new RandomAccessFile("D:\\Channel\\Data\\lock\\c.txt","rw");
        FileChannel channel = file.getChannel();
        System.out.println("独占锁获取开始,当前时间为：" + new Date().toLocaleString());
        FileLock lock = channel.lock(0, Long.MAX_VALUE, false);
        System.out.println("独占锁获取成功,当前时间为：" + new Date().toLocaleString());

    }

}
