package com.weibin.nio.channel.mappedbuffer;
import java.io.IOException;
import java.nio.ByteBuffer;
import	java.nio.file.StandardOpenOption;

import java.io.File;
import java.nio.channels.FileChannel;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2019/12/30
 **/
public class FileChannelOpenReadTest {

    public static void main(String[] args) throws IOException {
        File file = new File("D:\\Channel\\Data\\mapMode\\g.txt");
        FileChannel channel = FileChannel.open(file.toPath(), StandardOpenOption.READ, StandardOpenOption.READ);
        ByteBuffer buffer = ByteBuffer.allocate(10);
        channel.read(buffer);
        byte[] array = buffer.array();
        for (int i = 0; i < array.length; i++){
            System.out.print((char) array[i]);
        }
        channel.close();
    }

}
