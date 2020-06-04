package com.weibin.socket.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/6
 **/
public class ServerSocketSendBufferSizeTest {

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(8088);
        Socket accept = socket.accept();
        InputStream in = accept.getInputStream();
        InputStreamReader reader = new InputStreamReader(in);
        char[] chars = new char[1024];
        int read = reader.read(chars);
        long start = System.currentTimeMillis();
        while (read != -1){
            String str = new String(chars,0,read);
            System.out.println(str);
            read = reader.read(chars);
        }
        long end = System.currentTimeMillis();
        System.out.println("time : " + (end - start));
        in.close();
        accept.close();
        socket.close();
    }

}
