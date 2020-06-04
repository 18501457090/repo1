package com.weibin.nio.channel.lock;
import java.io.FileNotFoundException;
import	java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Desc: 验证共享锁字节不能写
 * @author: zwb
 * @Date: 2019/12/29
 **/
public class FileChannelCheckSharedTest {

    public static void main(String[] args) throws Exception {
        RandomAccessFile raf = new RandomAccessFile("D:\\Channel\\Data\\lock\\a.txt","rw");
        FileChannel channel = raf.getChannel();
        channel.lock(1,2,true);
        channel.write(ByteBuffer.wrap("123456".getBytes()));// 操作锁定的区域，就会出现异常
    }

}
