package com.weibin.nio.channel.mappedbuffer;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2019/12/30
 **/
public class FileChannelMapModeReadWriteTest {

    public static void main(String[] args) throws Exception {
        RandomAccessFile raf = new RandomAccessFile("D:\\Channel\\Data\\mapMode\\a.txt","rw");
        FileChannel channel = raf.getChannel();
        MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0, 10);
        map.put((byte)'o');
        map.put((byte)'p');
        map.put((byte)'q');
        map.put((byte)'r');
        map.put((byte)'s');
        channel.close();
        raf.close();
    }

}
