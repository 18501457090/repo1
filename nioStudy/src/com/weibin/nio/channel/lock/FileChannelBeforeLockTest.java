package com.weibin.nio.channel.lock;
import java.io.FileNotFoundException;
import	java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2019/12/29
 **/
public class FileChannelBeforeLockTest {

    public static void main(String[] args) throws Exception {
        RandomAccessFile raf = new RandomAccessFile("D:\\Channel\\Data\\lock\\a.txt","rw");
        FileChannel channel = raf.getChannel();
        channel.lock(3,2,true);
        channel.write(ByteBuffer.wrap("1".getBytes()));
        channel.write(ByteBuffer.wrap("2".getBytes()));
        channel.write(ByteBuffer.wrap("3".getBytes()));
        channel.write(ByteBuffer.wrap("4".getBytes()));
        channel.close();
        raf.close();
    }

}
