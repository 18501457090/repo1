package com.review.channel;

import java.io.*;
import java.math.BigDecimal;
import java.nio.channels.FileChannel;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/2/21
 **/
public class BigDecimalTest {

    public static void main(String[] args) throws IOException {
        FileInputStream in= new FileInputStream("");
        FileChannel channel = in.getChannel();
        FileDescriptor fd = in.getFD();
        fd.valid();
    }

}
