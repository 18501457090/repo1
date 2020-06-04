package com.weibin.bio;

import java.io.BufferedOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/5/30
 **/
public class FileWriterTest {

    public static void main(String[] args) {
        try (Writer writer = new FileWriter("a.txt")){
            writer.write("hello word!");
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
