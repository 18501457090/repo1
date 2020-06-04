package com.weibin.nio.network.basestudy;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/2
 **/
public class IsSupportMulticastTest {

    public static void main(String[] args) throws SocketException {
        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
        while (interfaces.hasMoreElements()){
            NetworkInterface nextElement = interfaces.nextElement();
            System.out.println("网络设备名称：" + nextElement.getName());
            System.out.println("网络设备显示名称：" + nextElement.getDisplayName());
            System.out.println("是否支持组播？ ： " + nextElement.supportsMulticast());
            System.out.println();
            System.out.println(" - - - - - - - --  - -  - - -- - - - - - - --  -");
            System.out.println();
        }
    }

}
