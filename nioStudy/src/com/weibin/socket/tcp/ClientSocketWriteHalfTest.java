package com.weibin.socket.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/5
 **/
public class ClientSocketWriteHalfTest {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",8088);
        InputStream in = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int read;
        while ((read = in.read(bytes)) != -1){
            System.out.print(new String(bytes,0,read));
            read = in.read(bytes);
        }
        in.close();
        socket.close();

    }


}
