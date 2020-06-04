package com.weibin.socket.tcp;

import java.io.IOException;
import java.net.Socket;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/5
 **/
public class ClientSocketTest_13 {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",8088);
    }

}
