package com.weibin.nio.network.basestudy;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/1
 **/
public class InetAddressTest_4 {

    public static void main(String[] args) throws UnknownHostException {
        InetAddress[] allByName = InetAddress.getAllByName("DESKTOP-7PB5S07");
        InetAddress[] allByName1 = InetAddress.getAllByName("www.taobao.com");
        InetAddress[] allByName2 = InetAddress.getAllByName("192.168.1.4");
        for (InetAddress addr : allByName){
            System.out.println("address : " + addr.getHostAddress() + " name : " + addr.getHostName() +
                    " className : " + addr.getClass().getName());
        }
        System.out.println(" ---------------------------- ");
        for (InetAddress addr : allByName1){
            System.out.println("address : " + addr.getHostAddress() + " name : " + addr.getHostName() +
                    " className : " + addr.getClass().getName());
        }
        System.out.println(" ---------------------------- ");
        for (InetAddress addr : allByName2){
            System.out.println("address : " + addr.getHostAddress() + " name : " + addr.getHostName() +
                    " className : " + addr.getClass().getName());
        }
    }

}
