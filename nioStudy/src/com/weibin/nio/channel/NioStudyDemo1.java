package com.weibin.nio.channel;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.IntBuffer;
import java.nio.charset.Charset;

public class NioStudyDemo1 {

    public static void main(String[] args) throws UnsupportedEncodingException {
        byte[] bytes = "我是中国人".getBytes("UTF-16BE");
        // 执行本代码的*.java文件是UTF-8编码。所以运行环境取得的编码是UTF-8
        System.out.println(Charset.defaultCharset().name());
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        CharBuffer buffer = byteBuffer.asCharBuffer();
        for (int i = 0; i < buffer.capacity();i++){
            // 这里会出现乱码，因为get()方法使用的编码为UTF-16BE，
            // 不是同一种编码
            System.out.print(buffer.get() + "  ");
        }


    }

}
