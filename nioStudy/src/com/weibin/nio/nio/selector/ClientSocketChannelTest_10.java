package com.weibin.nio.nio.selector;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/12
 **/
public class ClientSocketChannelTest_10 {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",8088);
        OutputStream out = socket.getOutputStream();
        out.write("send Data to Server!".getBytes());
        out.close();
        socket.close();
    }

}
