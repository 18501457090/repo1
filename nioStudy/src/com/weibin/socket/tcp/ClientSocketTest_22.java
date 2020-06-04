package com.weibin.socket.tcp;
import	java.util.Date;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/6
 **/
public class ClientSocketTest_22 {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",8088);
        socket.setTcpNoDelay(false);
        InputStream in = socket.getInputStream();
        long now = System.currentTimeMillis();
        byte[] bytes = new byte[1];
        int read = in.read(bytes);
        while (read != -1){
            String str = new String(bytes,0,read);
            System.out.println(str);
            read = in.read(bytes);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - now);
        socket.close();
    }

}
