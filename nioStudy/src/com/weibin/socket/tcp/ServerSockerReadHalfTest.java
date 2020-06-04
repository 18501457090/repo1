package com.weibin.socket.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/5
 **/
public class ServerSockerReadHalfTest {

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(8088);
        Socket accept = socket.accept();
        InputStream in = accept.getInputStream();
        System.out.println("A : " + in.available());
        byte[] bytes = new byte[2];
        int read = in.read(bytes);
        System.out.println("取得的数据：" + new String(bytes,0,read));
        accept.shutdownInput(); // 屏蔽InputStream，到达流的末尾
        System.out.println("B :" + in.available());// 静默丢弃其他数据
        read = in.read(bytes); // -1
        System.out.println("read : " + read);
        in = accept.getInputStream();// 抛出异常
        accept.close();
        socket.close();
    }

}
