package com.weibin.nio.network.basestudy;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/1
 **/
public class InetAddressTest_7 {

    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getLocalHost();
        System.out.println("A1 : " + address.getCanonicalHostName());
        System.out.println("A2 : " + address.getHostName());
        System.out.println();
        InetAddress address1 = InetAddress.getByName("www.taobao.com");
        System.out.println("B1 : " + address1.getCanonicalHostName());
        System.out.println("B2 : " + address1.getHostName());
        System.out.println();
        InetAddress address2 = InetAddress.getByName("192.168.1.4");
        System.out.println("C1 : " + address2.getCanonicalHostName());
        System.out.println("C2 : " + address2.getHostName());


    }

}
