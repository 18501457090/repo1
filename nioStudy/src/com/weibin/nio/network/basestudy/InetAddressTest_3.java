package com.weibin.nio.network.basestudy;
import	java.net.InetAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/1
 **/
public class InetAddressTest_3 {

    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getByName("www.baidu.com"); // 根据域名获取
        InetAddress address1 = InetAddress.getByName("192.168.1.4");
        InetAddress byName = InetAddress.getByName("DESKTOP-7PB5S07"); // 根据计算机名获取
        InetAddress address2 = InetAddress.getByName("localhost"); // 根据域名获取
        System.out.println("address : " + address.getHostAddress());
        System.out.println("address1 : " + address1.getHostAddress());
        System.out.println("address2 : " + address2.getHostAddress());
        System.out.println("byName : " + byName.getHostAddress());
    }

}
