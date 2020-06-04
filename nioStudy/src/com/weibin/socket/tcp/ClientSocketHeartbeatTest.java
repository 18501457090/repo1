package com.weibin.socket.tcp;

import java.io.IOException;
import java.net.Socket;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/7
 **/
public class ClientSocketHeartbeatTest {

    public static void main(String[] args) throws IOException, InterruptedException {

        Socket socket = new Socket("localhost",8088);
        int count = 0;
        for (;;){
            socket.sendUrgentData(1);
            count++;
            System.out.println("共执行了" + count + "次嗅探");
            Thread.sleep(1000);
        }
    }


}
