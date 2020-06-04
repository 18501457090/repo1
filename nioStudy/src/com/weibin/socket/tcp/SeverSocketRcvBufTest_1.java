package com.weibin.socket.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/5
 **/
public class SeverSocketRcvBufTest_1 {

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket();
        System.out.println("A receiveBufferSize() : " + socket.getReceiveBufferSize());
        socket.setReceiveBufferSize(66);
        System.out.println("B receiveBufferSize() : " + socket.getReceiveBufferSize());
        socket.bind(new InetSocketAddress("localhost",8088),90);
        Socket accept = socket.accept();
        InputStream in = accept.getInputStream();
        InputStreamReader reader = new InputStreamReader(in);
        char[] chars = new char[1024];
        int readLength = reader.read(chars);
        while (readLength != -1){
            String str = new String(chars,0,readLength);
            System.out.println(str);
            readLength = reader.read(chars);
        }
        in.close();
        accept.close();
        socket.close();



    }

}
