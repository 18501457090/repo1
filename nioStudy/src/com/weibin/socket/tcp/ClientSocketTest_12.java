package com.weibin.socket.tcp;
import com.weibin.socket.pojo.UserInfo;

import	java.io.ObjectInputStream;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Date;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/5
 **/
public class ClientSocketTest_12 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket socket = new Socket("localhost",8088);
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(out);
        ObjectInputStream ois = new ObjectInputStream(in);
        for (int i = 0; i < 5; i++){
            UserInfo info = new UserInfo();
            info.setId(i);
            info.setPassword("clientPassword" + i + "    " + new Date().toLocaleString());
            info.setUsername("clientUserName" + i + "    " + new Date().toLocaleString());
            oos.writeObject(info);
            UserInfo ufo = (UserInfo) ois.readObject();
            System.out.println("客户端接受到的实体类信息为："  + ufo);
        }
        oos.close();
        ois.close();
        socket.close();
    }

}
