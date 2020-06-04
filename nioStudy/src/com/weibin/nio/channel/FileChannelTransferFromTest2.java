package com.weibin.nio.channel;
import java.io.FileNotFoundException;
import java.io.IOException;
import	java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2019/12/28
 **/
public class FileChannelTransferFromTest2 {

    public static void main(String[] args) throws IOException {
        RandomAccessFile rafA = new RandomAccessFile("D:\\Channel\\Data\\read\\d.txt","rw");
        RandomAccessFile rafB = new RandomAccessFile("D:\\Channel\\Data\\read\\e.txt","rw");
        FileChannel channelA = rafA.getChannel();
        FileChannel channelB = rafB.getChannel();
        channelB.position(2);
        // 如果count的字节个数小于src.remaining，
        // 则count字节数传输到当前通道的position位置
        long readLength = channelA.transferFrom(channelB, 3, 2);
        System.out.println(readLength);
        channelA.close();
        channelB.close();
        rafA.close();
        rafB.close();
    }

}
