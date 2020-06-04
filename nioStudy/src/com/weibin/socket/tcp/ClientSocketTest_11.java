package com.weibin.socket.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/4
 **/
public class ClientSocketTest_11 {

    public static void main(String[] args) throws IOException {
        ClientSocketTest_11 clientSocketTest_11 = new ClientSocketTest_11();
    }

    public ClientSocketTest_11() throws IOException {
        Socket socket = new Socket("localhost",8088);
        OutputStream out = socket.getOutputStream();
        for(int i = 0; i < 3; i++){
            out.write("123456789".getBytes());
        }
        out.close();
        socket.close();
    }
}
