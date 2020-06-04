package com.weibin.nio.channel.standardoperation;
import java.io.IOException;
import java.nio.ByteBuffer;
import	java.nio.file.StandardOpenOption;

import java.io.File;
import java.nio.channels.FileChannel;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/1
 **/
public class FileChannelCreateSparseFileTest {


    public static void main(String[] args) throws IOException {
        File file = new File("D:\\Channel\\Data\\mapMode\\i.txt");
        FileChannel channel = FileChannel.open(file.toPath(),
                StandardOpenOption.CREATE_NEW,StandardOpenOption.SPARSE,StandardOpenOption.WRITE);
        channel.position(Integer.MAX_VALUE);
        channel.write(ByteBuffer.wrap("a".getBytes()));
        ByteBuffer allocate = ByteBuffer.allocate(1);
        channel.close();
    }

}
