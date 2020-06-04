package com.weibin.socket.tcp;
import	java.util.Date;
import java.io.IOException;
import	java.net.Socket;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/2
 **/
public class ClientSocketTest {

    public static void main(String[] args) throws IOException {
        System.out.println("客户端连接开始 ： " + new Date().toLocaleString());
        Socket socket = new Socket("www.baidu.com",80);
        System.out.println("客户端连接结束 ： " + new Date().toLocaleString());

    }

}
