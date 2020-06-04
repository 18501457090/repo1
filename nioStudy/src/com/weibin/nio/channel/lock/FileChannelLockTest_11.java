package com.weibin.nio.channel.lock;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2019/12/29
 **/
public class FileChannelLockTest_11 {

    public static void main(String[] args) throws Exception {
        RandomAccessFile file = new RandomAccessFile("D:\\Channel\\Data\\lock\\d.txt","rw");
        FileChannel channel = file.getChannel();
        System.out.println("channel.hashCode() : " + channel.hashCode());
        FileLock lock = channel.lock(1, 10, true);
        System.out.println("shredLock-------> " + " position : " + lock.position() + " size : " + lock.size() + " isValid() " + lock.isValid()
            + " isShared() : " + lock.isShared() + " lock.channel().hashCode() : " + lock.channel().hashCode() +
                " lock.acquiredBy().hashCode():" + lock.acquiredBy().hashCode());
        lock.release();
        lock = channel.lock(1,10,false);
        System.out.println("exclusiveLock-------> " + " position : " + lock.position() + " size : " + lock.size() + " isValid() " + lock.isValid()
                + " isShared() : " + lock.isShared() + " lock.channel().hashCode() : " + lock.channel().hashCode() +
                " lock.acquiredBy().hashCode():" + lock.acquiredBy().hashCode());
        lock.close();
        channel.close();
        System.out.println("close-------> " + " position : " + lock.position() + " size : " + lock.size() + " isValid() " + lock.isValid()
                + " isShared() : " + lock.isShared() + " lock.channel().hashCode() : " + lock.channel().hashCode() +
                " lock.acquiredBy().hashCode():" + lock.acquiredBy().hashCode());

    }

}
