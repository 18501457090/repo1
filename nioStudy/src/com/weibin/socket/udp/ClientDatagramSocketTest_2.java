package com.weibin.socket.udp;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

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
public class ClientDatagramSocketTest_2 {

    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        socket.connect(new InetSocketAddress("localhost",8088));
        String str = "helloword";
        byte[] bytes = str.getBytes();
        DatagramPacket packet = new DatagramPacket(new byte[]{},0);
        packet.setData(bytes,2,6);
        System.out.println("offset : " + packet.getOffset());
        socket.send(packet);
        socket.close();

    }

}
