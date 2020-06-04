package com.weibin.nio.channel.test;
import	java.nio.ByteBuffer;
import java.io.IOException;
import	java.nio.file.StandardOpenOption;

import java.io.File;
import java.nio.channels.FileChannel;
import java.util.Arrays;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/1
 **/
public class FileChannelReadWriteTest {

    public static void main(String[] args) throws IOException {
        File readFile = new File("D:\\Channel\\Data\\read\\a.txt");
        FileChannel channel = FileChannel.open(readFile.toPath(),StandardOpenOption.READ);
       /* File wtiteFile = new File("D:\\Channel\\Data\\read\\a1.txt");
        FileChannel copy = FileChannel.open(wtiteFile.toPath(),StandardOpenOption.WRITE,StandardOpenOption.CREATE);
        channel.transferTo(0,channel.size(), copy);*/
        ByteBuffer allocate = ByteBuffer.allocate(10);
        while (channel.read(allocate) != -1){
            byte[] array = allocate.array();
            for (int i = 0 ; i < array.length; i++){
                System.out.print((char) array[i]);
            }
            System.out.println();
            allocate.clear();
        }
        channel.close();
        //copy.close();
    }

}
