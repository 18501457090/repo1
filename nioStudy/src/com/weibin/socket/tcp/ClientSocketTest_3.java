package com.weibin.socket.tcp;
import	java.util.Date;

import java.io.IOException;
import java.net.Socket;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/4
 **/
public class ClientSocketTest_3 {

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("ClientSocket begin！" + new Date().toLocaleString());
        Socket socket = new Socket("localhost",8088);
        System.out.println("ClientSocket end！" + new Date().toLocaleString());
        Thread.sleep(Integer.MAX_VALUE);
        socket.close();
    }

}
