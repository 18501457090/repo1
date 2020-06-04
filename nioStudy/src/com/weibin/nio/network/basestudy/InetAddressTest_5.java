package com.weibin.nio.network.basestudy;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/1
 **/
public class InetAddressTest_5 {


    public static void main(String[] args) throws UnknownHostException {
        System.out.println((256 - 64) + "." + (256 - 88) + "." + 1 + "." + 4);
        byte[] bytes = {-64,-88,1,4};
        InetAddress byAddress = InetAddress.getByAddress(bytes);
        System.out.println("HostAddress : " + byAddress.getHostAddress());
        System.out.println("HostName : " + byAddress.getHostName());
        System.out.println("className :" + byAddress.getClass().getName());
    }

}
