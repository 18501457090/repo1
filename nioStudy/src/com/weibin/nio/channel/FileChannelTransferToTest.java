package com.weibin.nio.channel;
import java.io.FileNotFoundException;
import	java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * @Desc: 1.如果给定的位置大于该文件的当前大小，则不传输任何字节。
 *        2.正常传输字节测试
 * @author: zwb
 * @Date: 2019/12/28
 **/
public class FileChannelTransferToTest {

    public static void main(String[] args) throws Exception {
        // b.txt 初始内容为123456789
        RandomAccessFile rafA = new RandomAccessFile("D:\\Channel\\Data\\read\\a.txt","rw");
        RandomAccessFile rafB = new RandomAccessFile("D:\\Channel\\Data\\read\\b.txt","rw");
        FileChannel rafAChannel = rafA.getChannel();
        FileChannel rafBChannel = rafB.getChannel();
        rafBChannel.position(9);
        rafAChannel.transferTo(2,4,rafBChannel);
        rafAChannel.close();
        rafBChannel.close();
        rafA.close();
        rafB.close();
    }

}
