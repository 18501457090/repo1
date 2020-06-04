package com.weibin.socket.tcp;

import java.io.IOException;
import java.net.Socket;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/4
 **/
public class ClientSocketTest_10 {

    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("localhost",8088);
        socket.close();
        Thread.sleep(2000);
    }

}
