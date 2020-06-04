package com.weibin.socket.tcp;
import	java.io.FileOutputStream;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/4
 **/
public class ServerSocketTest_9 {

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(8088);
        Socket accept = socket.accept();
        InputStream in = accept.getInputStream();
        byte[] bytes = new byte[2048];
        int read = in.read(bytes);
        FileOutputStream out = new FileOutputStream("D:\\a.jpg");
        while (read != -1){
            out.write(bytes,0,read);
            read = in.read(bytes);
        }
        out.close();
        in.close();
        accept.close();
        socket.close();



    }

}
