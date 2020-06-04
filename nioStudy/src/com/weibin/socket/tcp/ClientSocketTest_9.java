package com.weibin.socket.tcp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Desc: 使用Socket传递PNG图片
 * @author: zwb
 * @Date: 2020/1/4
 **/
public class ClientSocketTest_9 {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",8088);
        File file = new File("D:\\love.jpg");
        FileInputStream in = new FileInputStream(file);
        byte[] bytes = new byte[2048];
        int read = in.read(bytes);
        OutputStream out = socket.getOutputStream();
        while (read != -1){
            out.write(bytes,0,read);
            read = in.read(bytes);
        }
        out.close();
        in.close();
        socket.close();


    }


}
