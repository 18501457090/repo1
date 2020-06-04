package com.weibin.socket.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/7
 **/
public class ServerSocketOOBInlineTest_1 {

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(8088);
        Socket accept = socket.accept();
        System.out.println("紧急数据默认状态：" + accept.getOOBInline());
        //accept.setOOBInline(true);
        InputStream in = accept.getInputStream();
        InputStreamReader reader = new InputStreamReader(in);
        char[] cbuf = new char[1024];
        int read = reader.read(cbuf);
        while (read != -1){
            String str = new String(cbuf,0,read);
            System.out.println(str);
            read = reader.read(cbuf);
        }
        in.close();
        accept.close();
        socket.close();
    }

}
