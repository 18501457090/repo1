package com.weibin.nio.channel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2019/12/28
 **/
public class FileChannelNOAlterPositionTest {


    public static void main(String[] args) throws Exception {
        // 执行write(ByteBuffer src,long position)方法不改变position的位置，
        // 也就是绝对位置操作不影响position的值
        FileOutputStream outputStream = new FileOutputStream("D:\\Channel\\Data\\write\\WriteTest_7.txt");
        FileChannel channel = outputStream.getChannel();
        System.out.println("A currentPosition: " + channel.position());
        channel.position(3);
        System.out.println("B currentPosition: " + channel.position());
        channel.write(ByteBuffer.wrap("abcde".getBytes()),0);
        System.out.println("C currentPosition: " + channel.position());
        channel.close();



    }

}
