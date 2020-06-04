package com.weibin.socket.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/6
 **/
public class ClientSocketLingertest_1 {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket();
        // 设置超小的接收缓冲区,目的是先让服务器close(),
        // 然后将服务端发送缓冲区中的数据再传入客户端的接收缓冲区中,
        // 虽然服务端的close()方法已经执行，但是数据不会丢失
        socket.setReceiveBufferSize(1);
        socket.connect(new InetSocketAddress("localhost",8088));
        InputStream in = socket.getInputStream();
        byte[] bytes = new byte[1];
        int read = in.read(bytes);
        while (read != -1){
            String str = new String(bytes,0,read);
            System.out.println(str);
            read = in.read(bytes);
        }
        System.out.println("client endTime : " + System.currentTimeMillis());
        in.close();
        socket.close();
    }

}
