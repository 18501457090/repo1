package com.weibin.bio.reader;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/5/30
 **/
public class CovertBufferReaderStudy {


    public static void main(String[] args) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        writer.write("aaaaaa");
        writer.flush();
        writer.close();
    }


}
