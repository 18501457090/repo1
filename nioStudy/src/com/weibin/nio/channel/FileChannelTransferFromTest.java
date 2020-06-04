package com.weibin.nio.channel;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2019/12/28
 **/
public class FileChannelTransferFromTest {

    public static void main(String[] args) throws Exception {
        // d.txt初始化内容为 ： abcdefg  e.txt初始化内容为：123456789
        RandomAccessFile fileA = new RandomAccessFile("D:\\Channel\\Data\\read\\d.txt","rw");
        RandomAccessFile fileB = new RandomAccessFile("D:\\Channel\\Data\\read\\e.txt","rw");
        FileChannel channelA = fileA.getChannel();
        FileChannel channelB = fileB.getChannel();
        channelB.position(4);
        // 如果给定的位置大于该文件的当前大小，则不传输任何字节
        long readLength = channelA.transferFrom(channelB, 3, 2);
        System.out.println(readLength);
        channelA.close();
        channelB.close();
        fileA.close();
        fileB.close();
    }

}
