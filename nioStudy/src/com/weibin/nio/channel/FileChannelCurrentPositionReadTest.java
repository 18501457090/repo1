package com.weibin.nio.channel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelCurrentPositionReadTest {

    private static FileInputStream in;
    private static FileChannel channel;

    public static void main(String[] args) throws IOException {
        in = new FileInputStream("D:\\Channel\\Data\\ReadData.txt");
        channel = in.getChannel();
        channel.position(3);
        ByteBuffer buffer = ByteBuffer.allocate(6);
        int read = channel.read(buffer);
        System.out.println(read);
        byte[] array = buffer.array();
        System.out.println(new String(array,"UTF-8"));


    }


}
