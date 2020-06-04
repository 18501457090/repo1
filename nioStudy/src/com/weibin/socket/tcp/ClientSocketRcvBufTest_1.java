package com.weibin.socket.tcp;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import	java.net.Socket;
import java.net.SocketException;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/5
 **/
public class ClientSocketRcvBufTest_1 {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket();
        System.out.println("begin " + socket.getReceiveBufferSize());
        socket.connect(new InetSocketAddress("localhost",8088));
        System.out.println("connected : " + socket.getReceiveBufferSize());
        OutputStream out = socket.getOutputStream();
        for (int i = 0; i < 10; i++){
            out.write(("QY,I Love You,I Love You,I Love You,I Love You,I Love You,I Love You," +
                    "I Love You,I Love You,I Love You,I Love You,I Love You,I Love You," +
                    "I Love You,I Love You,I Love You,I Love You,I Love You,I Love You," +
                    "I Love You,I Love You,I Love You,I Love You,I Love You,I Love You," +
                    "I Love You,I Love You,I Love You,I Love You,I Love You,I Love You," +
                    "I Love You,I Love You,I Love You,I Love You,I Love You,I Love You," +
                    "I Love You,I Love You,I Love You,I Love You,I Love You,I Love You," +
                    "I Love You,I Love You,I Love You,I Love You,I Love You,I Love You,").getBytes());
        }
        out.close();
        socket.close();


    }

}
