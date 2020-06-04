package com.weibin.nio.network.basestudy;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/1
 **/
public class InetAddressTest_6 {

    public static void main(String[] args) throws UnknownHostException {
        byte[] bytes = new byte[]{-64,-88,1,4};
        InetAddress address = InetAddress.getByAddress("aaa", bytes);
        System.out.println("HostAddress : " + address.getHostAddress());
        System.out.println("HostName : " + address.getHostName());
        System.out.println("ClassName : " + address.getClass().getName());

    }

}
