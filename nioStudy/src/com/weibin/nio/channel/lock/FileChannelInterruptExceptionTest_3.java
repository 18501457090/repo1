package com.weibin.nio.channel.lock;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2019/12/29
 **/
public class FileChannelInterruptExceptionTest_3 {

    public static void main(String[] args) throws Exception {
        Thread t = new Thread(()->{
            try (RandomAccessFile raf = new RandomAccessFile("D:\\Channel\\Data\\lock\\a.txt","rw");
                 FileChannel channel = raf.getChannel();){
                System.out.println("B Begin!");
                channel.lock(0,2,false);
                System.out.println("B end");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        t.start();
        Thread.sleep(2000);
        t.interrupt();
    }

}
