package com.weibin.nio.nio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/12
 **/
public class ServerSocketTest_1 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8088);
        Socket socket = serverSocket.accept();
        InputStream in = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int readLength = in.read(bytes);
        while (readLength != -1){
            System.out.println(new String(bytes,0,readLength));
            readLength = in.read(bytes);
        }
        in.close();
        socket.close();
        serverSocket.close();
    }

}
