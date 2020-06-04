package com.weibin.nio.channel;
import	java.io.FileInputStream;
import java.io.FileNotFoundException;
import	java.io.FileOutputStream;

import java.nio.channels.FileChannel;

public class FileChannelFactory {

    static final int READ_TYPE = 2;
    static final int WRITE_TYPE = 1;

    static final FileChannel instance(String path,int type) throws FileNotFoundException {
        if (1 == type){
            return new FileOutputStream(path).getChannel();
        }
        return new FileInputStream(path).getChannel();
    }

    static final FileOutputStream getInstance(String path) throws FileNotFoundException {
        return new FileOutputStream(path);
    }

}
