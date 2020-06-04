package com.weibin.socket.tcp;
import	java.util.Date;
import com.weibin.socket.pojo.UserInfo;

import	java.io.ObjectOutputStream;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/5
 **/
public class ServerSocketTest_12 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket socket = new ServerSocket(8088);
        Socket accept = socket.accept();
        InputStream in = accept.getInputStream();
        OutputStream out = accept.getOutputStream();
        ObjectInputStream ois = new ObjectInputStream(in);
        ObjectOutputStream oos = new ObjectOutputStream(out);
        for (int i = 0; i < 5; i++){
            UserInfo userInfo = (UserInfo) ois.readObject();
            System.out.println("服务端接收到的实体类信息：" + userInfo);
            UserInfo info = new UserInfo();
            info.setId(userInfo.getId() + 1);
            info.setUsername(userInfo.getUsername() + i + "    " + new Date().toLocaleString());
            info.setPassword(userInfo.getPassword() + i + "    " + new Date().toLocaleString());
            oos.writeObject(info);
        }
        oos.close();
        ois.close();
        accept.close();
        socket.close();
    }

}
