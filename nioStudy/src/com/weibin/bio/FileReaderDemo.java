package com.weibin.bio;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/5/30
 **/
public class FileReaderDemo {


    public static void main(String[] args) {
        try (FileReader reader = new FileReader("D:\\develop\\workSpace\\nioStudy\\src\\com\\weibin\\bio\\FileWriterTest.java")){
            int position = 0;
            while ((position = reader.read()) != -1){
                System.out.print((char)position);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
