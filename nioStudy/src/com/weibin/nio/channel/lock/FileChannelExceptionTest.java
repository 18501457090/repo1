package com.weibin.nio.channel.lock;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2019/12/29
 **/
public class FileChannelExceptionTest {

    private static FileOutputStream out;
    private static FileChannel channel;

    public static void main(String[] args) throws Exception {
        out = new FileOutputStream("D:\\Channel\\Data\\lock\\a.txt");
        channel = out.getChannel();
        Thread a = new Thread(()->{
            try {
                channel.lock(1,2,false);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        Thread b = new Thread(()->{
            try {
                channel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        a.start();
        Thread.sleep(1);
        b.start();
        Thread.sleep(1000);
        out.close();
        channel.close();
    }

}
