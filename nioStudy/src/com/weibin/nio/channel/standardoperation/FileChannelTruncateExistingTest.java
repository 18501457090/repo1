package com.weibin.nio.channel.standardoperation;
import java.io.IOException;
import	java.nio.file.StandardOpenOption;
import	java.nio.channels.FileChannel;

import java.io.File;
import java.nio.channels.FileChannel;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/1
 **/
public class FileChannelTruncateExistingTest {

    public static void main(String[] args) throws IOException {
        File file = new File("D:\\Channel\\Data\\mapMode\\h.txt");
        // 如果文件已经存在并且为写入访问而打开，则其长度被截断为0
        FileChannel channel = FileChannel.open(file.toPath(),
                StandardOpenOption.CREATE,StandardOpenOption.WRITE,StandardOpenOption.DELETE_ON_CLOSE);
        channel.close();

    }

}
