package com.weibin.nio.nio;
import java.io.IOException;
import java.nio.ByteBuffer;
import	java.nio.file.StandardOpenOption;

import java.io.File;
import java.nio.channels.FileChannel;
import java.util.Date;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/12
 **/
public class TestData {

    public static void main(String[] args) throws IOException {
        FileChannel channel = FileChannel.open(new File("D:\\Channel\\Data\\write\\TestData_1.txt").toPath(), StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE);
        for (int i = 0;i < 3000000; i++){
            channel.write(ByteBuffer.wrap(((new Date().toLocaleString()) + "  " + (Thread.currentThread().getName()) + " abcdefghijklmnopqrstuvwxyz\r\n").getBytes()));
        }
        channel.close();
    }

}
