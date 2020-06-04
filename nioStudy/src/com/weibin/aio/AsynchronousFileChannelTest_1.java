package com.weibin.aio;

import java.io.IOException;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/16
 **/
public class AsynchronousFileChannelTest_1 {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("D:\\Channel\\Data\\AsynchonousFileChannel\\1.txt");
        AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(path, StandardOpenOption.READ);
        System.out.println("size : " + fileChannel.size());
        System.out.println("befor isOpen : " + fileChannel.isOpen());
        fileChannel.close();
        System.out.println("after isOpen : " + fileChannel.isOpen());
    }

}
