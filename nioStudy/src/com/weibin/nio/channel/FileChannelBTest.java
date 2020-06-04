package com.weibin.nio.channel;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2019/12/29
 **/
public class FileChannelBTest {

    public static void main(String[] args) throws Exception {
        RandomAccessFile raf = new RandomAccessFile("D:\\Channel\\Data\\lock\\a.txt","rw");
        FileChannel channel = raf.getChannel();
        System.out.println("B Begin!");
        channel.lock(1,2,false);
        System.out.println("B End!");
        Thread.sleep(Integer.MAX_VALUE);
        channel.close();
        raf.close();
    }

}
