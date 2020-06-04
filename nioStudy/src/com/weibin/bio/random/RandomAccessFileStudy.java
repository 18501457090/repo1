package com.weibin.bio.random;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/5/30
 **/
public class RandomAccessFileStudy {


    // 10894
    public static void main(String[] args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile("D:\\WriterDemo/1.txt","r");
        FileChannel channel = raf.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        int read = channel.read(byteBuffer, 10000);
        System.out.println("readSize : " + read);
        raf.close();
        //System.out.println(new String(byteBuffer.array(),"UTF8"));
    }




}
