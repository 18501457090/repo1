package com.weibin.nio.channel;
import	java.nio.ByteBuffer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class WriteOnCurrentPositionTest {


    public static void main(String[] args) throws IOException {
        File file = new File("D:\\Channel\\Data\\write\\WriteTest.txt");

        FileOutputStream out = new FileOutputStream(file);
        FileChannel outChannel = out.getChannel();
        outChannel.write(ByteBuffer.wrap("123456".getBytes()));
        outChannel.position(3);
        ByteBuffer[] buffers = new ByteBuffer[]{ByteBuffer.wrap("ooooo1".getBytes()),ByteBuffer.wrap("ooooo2".getBytes())};
        outChannel.write(buffers);
        outChannel.close();
        out.close();
    }

}
