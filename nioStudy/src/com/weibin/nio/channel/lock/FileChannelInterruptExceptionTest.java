package com.weibin.nio.channel.lock;
import java.io.FileNotFoundException;
import	java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2019/12/29
 **/
public class FileChannelInterruptExceptionTest {

    public static void main(String[] args) throws Exception {
        FileOutputStream fos = new FileOutputStream("D:\\Channel\\Data\\lock\\a.txt");
        FileChannel channel = fos.getChannel();
        Thread t = new Thread(()->{
            for (int i = 0; i < 10000; i++){
                System.out.println(" i : " + (i + 1));
            }
            try {
                channel.lock(1,2,false);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        t.start();
        Thread.sleep(50);
        t.interrupt();
        t.join();
        channel.close();
        fos.close();
    }

}
