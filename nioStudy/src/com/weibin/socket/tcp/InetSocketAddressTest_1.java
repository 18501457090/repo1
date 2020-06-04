package com.weibin.socket.tcp;

import java.net.InetSocketAddress;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/5
 **/
public class InetSocketAddressTest_1 {

    public static void main(String[] args) {
        InetSocketAddress socketAddress1 = new InetSocketAddress("192.168.1.8",80);
        InetSocketAddress socketAddress2 = new InetSocketAddress("192.168.1.8",80);
        System.out.println("socketAddress1 : " + socketAddress1.getHostName());
        System.out.println("socketAddress2 : " + socketAddress2.getHostString());



    }

}
