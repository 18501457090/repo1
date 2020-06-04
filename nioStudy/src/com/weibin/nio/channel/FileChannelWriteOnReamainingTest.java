package com.weibin.nio.channel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelWriteOnReamainingTest {

    public static void main(String[] args) throws IOException {
        FileOutputStream out = new FileOutputStream("D:\\Channel\\Data\\write\\WriteTest_5.txt");
        FileChannel channel = out.getChannel();
        ByteBuffer wrap1 = ByteBuffer.wrap("abcde".getBytes());
        ByteBuffer wrap2 = ByteBuffer.wrap("12345".getBytes());
        wrap2.position(1);
        wrap2.limit(3);
        ByteBuffer wrap3 = ByteBuffer.wrap("dlelf1".getBytes());
        wrap3.position(2);
        wrap3.limit(4);
        ByteBuffer[] buffers = new ByteBuffer[]{wrap1,wrap2,wrap3};
        channel.write(buffers,1,2);
        channel.close();
        out.close();
    }

}
