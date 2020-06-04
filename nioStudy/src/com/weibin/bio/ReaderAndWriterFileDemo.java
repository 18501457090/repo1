package com.weibin.bio;

import java.io.*;
import java.nio.CharBuffer;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/5/30
 **/
public class ReaderAndWriterFileDemo {

    public static void main(String[] args) {
        try(Reader reader = new FileReader("D:\\develop\\workSpace\\nioStudy\\src\\com\\w" +
                "eibin\\bio\\FileWriterTest.java")){
            try (Writer writer = new FileWriter("D:/FileWriterTest.java")){
                CharBuffer charBuffer = CharBuffer.allocate(1024);
                int readBytes = 0;
                while ((readBytes = reader.read(charBuffer)) != -1){
                    System.out.println(readBytes);
                    writer.write(charBuffer.array(),0,readBytes);
                    charBuffer.clear();
                }
                writer.flush();
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }



}
