package com.weibin.socket.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/4
 **/
public class ServerSocketTest_6 {

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8088);
        Socket accept = ss.accept();
        InputStream stream = accept.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        String line;
        while ((line = reader.readLine()) != null){
            System.out.println(line);
        }
        OutputStream outputStream = accept.getOutputStream();
        outputStream.write(("服务端已收到数据,当前时间为：" + new Date().toLocaleString()).getBytes());
        reader.close();
        stream.close();
        accept.close();
        ss.close();
    }


}
