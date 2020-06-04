package com.weibin.nio.network.basestudy;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/2
 **/
public class NetworkInterface_Test_1 {

    public static void main(String[] args) throws UnknownHostException, SocketException {
        InetAddress address = InetAddress.getByName("127.0.0.1");
        NetworkInterface anInterface = NetworkInterface.getByInetAddress(address);
        System.out.println("网络设备名称：" + anInterface.getName());
        System.out.println("网络设备显示名称：" + anInterface.getDisplayName());
        Enumeration<InetAddress> inetAddresses = anInterface.getInetAddresses();
        while (inetAddresses.hasMoreElements()){
            InetAddress inetAddress = inetAddresses.nextElement();
            System.out.println("主机名称：" + inetAddress.getHostName());
            System.out.println("IP : " + inetAddress.getHostAddress());
        }


    }

}
