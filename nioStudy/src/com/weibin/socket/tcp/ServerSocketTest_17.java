package com.weibin.socket.tcp;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.UnknownHostException;
import java.util.Enumeration;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/5
 **/
public class ServerSocketTest_17 {

    public static void main(String[] args) throws IOException, InterruptedException {
        InetAddress host = null;
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        while (networkInterfaces.hasMoreElements()){
            NetworkInterface networkInterface = networkInterfaces.nextElement();
            final Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
            while (inetAddresses.hasMoreElements()){
                host = inetAddresses.nextElement();
                break;
            }
            break;
        }
        ServerSocket socket = new ServerSocket(8088,50,host);
        Thread.sleep(5000);
        for (int i = 0; i < 100; i++){
            System.out.println("accept " + (i + 1) + " begin!");
            socket.accept();
            System.out.println("accept " + (i + 1) + " end!");
        }
        socket.close();
    }

}
