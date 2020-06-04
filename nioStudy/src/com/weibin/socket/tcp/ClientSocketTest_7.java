package com.weibin.socket.tcp;
import	java.util.Date;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/4
 **/
public class ClientSocketTest_7 {

    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("localhost",8088);
        OutputStream stream = socket.getOutputStream();
        stream.write(("Client send test Data 1 " + new Date().toLocaleString() + "\r\n").getBytes());
        Thread.sleep(1000);
        stream.write(("Client send test Data 2 " + new Date().toLocaleString() + "\r\n").getBytes());
        Thread.sleep(1000);
        stream.write(("Client send test Data 3 " + new Date().toLocaleString() + "\r\n").getBytes());
        Thread.sleep(1000);
        stream.close();
        socket.close();
    }


}
