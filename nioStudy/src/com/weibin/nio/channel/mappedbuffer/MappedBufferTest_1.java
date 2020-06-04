package com.weibin.nio.channel.mappedbuffer;
import java.io.FileNotFoundException;
import	java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2019/12/30
 **/
public class MappedBufferTest_1 {

    public static void main(String[] args) throws Exception {
        RandomAccessFile raf = new RandomAccessFile("D:\\Channel\\Data\\mapMode\\a.txt","rw");
        FileChannel channel = raf.getChannel();
        MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, 0, 5);
        System.out.println((char)map.get() + " position : " + map.position()); //a
        System.out.println((char)map.get() + " position : " + map.position()); //b
        System.out.println((char)map.get() + " position : " + map.position()); //c
        System.out.println((char)map.get() + " position : " + map.position()); //d
        System.out.println((char)map.get() + " position : " + map.position()); //e
        System.out.println();
        map = channel.map(FileChannel.MapMode.READ_ONLY, 2, 2);
        System.out.println((char)map.get() + " position : " + map.position());
        System.out.println((char)map.get() + " position : " + map.position());
        Thread.sleep(500);
        System.out.println();
        // 抛出异常,因为超出映射的范围
        System.out.println((char)map.get() + " position : " + map.position());
        channel.close();
        raf.close();

    }


}
