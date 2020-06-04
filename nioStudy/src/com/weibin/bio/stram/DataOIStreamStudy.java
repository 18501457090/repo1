package com.weibin.bio.stram;


import java.io.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/5/30
 **/
public class DataOIStreamStudy {


    public static void main(String[] args) throws IOException {

        DataOutputStream dos = new DataOutputStream(new FileOutputStream("D://a.txt"));
        dos.writeBoolean(false);
        dos.writeUTF("HangZhou");
        dos.writeByte(1);
        dos.flush();
        dos.close();
        DataInputStream dis = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream("D://a.txt")));
        System.out.println(dis.readBoolean());
        AtomicInteger atomicInteger = new AtomicInteger(0);
        atomicInteger.incrementAndGet();
    }

}
