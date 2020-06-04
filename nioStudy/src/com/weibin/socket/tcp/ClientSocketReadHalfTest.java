package com.weibin.socket.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/5
 **/
public class ClientSocketReadHalfTest {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress("localhost",8088),1000);
        OutputStream out = socket.getOutputStream();
        out.write("abcdefg".getBytes());
        out.close();
        socket.close();
    }

}
