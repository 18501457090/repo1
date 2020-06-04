package com.weibin.socket.udp;
import java.io.IOException;
import	java.net.DatagramPacket;
import	java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/8
 **/
public class ClientDatagramSocketTruncateTest_1 {

    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        socket.connect(new InetSocketAddress("localhost",8088));
        String sb = "";
        for (int i = 0; i < 65555 -3 ; i++){
            sb = sb + "a";
        }
        sb = sb + "end";
        DatagramPacket packet = new DatagramPacket(sb.getBytes(),sb.getBytes().length);
        socket.send(packet);
        socket.close();

    }


}
