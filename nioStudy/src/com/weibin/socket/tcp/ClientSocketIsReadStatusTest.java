package com.weibin.socket.tcp;

import java.io.IOException;
import java.net.Socket;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/5
 **/
public class ClientSocketIsReadStatusTest {


    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",8088);
        socket.close();
    }

}
