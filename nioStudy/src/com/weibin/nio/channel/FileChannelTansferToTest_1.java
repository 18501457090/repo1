package com.weibin.nio.channel;
import java.io.FileNotFoundException;
import java.io.IOException;
import	java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * @Desc: 如果count的字节个数大于position到size的字节个数，
 * 则传输通道的size-position个字节个数到dest通道的当前位置。
 * @author: zwb
 * @Date: 2019/12/28
 **/
public class FileChannelTansferToTest_1 {

    public static void main(String[] args) throws IOException {
        // b.txt 初始内容：123456789cdef
        RandomAccessFile rafA = new RandomAccessFile("D:\\Channel\\Data\\read\\b.txt","rw");
        RandomAccessFile rafB = new RandomAccessFile("D:\\Channel\\Data\\read\\c.txt","rw");
        FileChannel rafAChannel = rafA.getChannel();
        FileChannel rafBChannel = rafB.getChannel();
        System.out.println("A position : " + rafBChannel.position());
        rafAChannel.transferTo(0,1000,rafBChannel);
        System.out.println("B position : " + rafBChannel.position());
        rafA.close();
        rafB.close();
        rafA.close();
        rafB.close();

    }

}
