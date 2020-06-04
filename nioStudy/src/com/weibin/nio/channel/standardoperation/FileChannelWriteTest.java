package com.weibin.nio.channel.standardoperation;
import java.nio.ByteBuffer;
import	java.nio.file.StandardOpenOption;

import java.io.File;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/1
 **/
public class FileChannelWriteTest {

    public static void main(String[] args) throws IOException {
        File file = new File("D:\\Channel\\Data\\mapMode\\h.txt");
        if (!file.exists()){
            file.createNewFile();
        }
        FileChannel channel = FileChannel.open(file.toPath(),StandardOpenOption.CREATE,StandardOpenOption.WRITE);
        channel.position(Integer.MAX_VALUE);
        channel.write(ByteBuffer.wrap("a".getBytes()));
        channel.close();
    }

}
