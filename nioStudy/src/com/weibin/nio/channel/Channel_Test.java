package com.weibin.nio.channel;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.spi.AbstractInterruptibleChannel;


public class Channel_Test {

    public static void main(String[] args) throws IOException {
        RandomAccessFile file = new RandomAccessFile("D:\\TestData.txt","rw");
        FileChannel channel = file.getChannel();
        long position = channel.position();
        boolean open = channel.isOpen();
        System.out.println("open : " + open + "  position : " + position);
    }


}
