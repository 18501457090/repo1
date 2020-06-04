package com.weibin.nio.network.basestudy;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/1
 **/
public class InetAddressTest {

    public static void main(String[] args) throws SocketException, UnknownHostException {
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        while (networkInterfaces.hasMoreElements()){
            NetworkInterface networkInterface = networkInterfaces.nextElement();
            Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
            if (inetAddresses != null ){
                while (inetAddresses.hasMoreElements()){
                    InetAddress inetAddress = inetAddresses.nextElement();
                    final InetAddress localHost = inetAddress.getLocalHost();
                    System.out.println("获取完全限定域名：" + inetAddress.getCanonicalHostName());
                    System.out.println("获取IP地址的主机名：" + inetAddress.getHostName());
                    System.out.println("获取IP地址：" + inetAddress.getHostAddress());
                    byte[] address = inetAddress.getAddress();
                    System.out.print("原始IP地址：");
                    for (int i = 0; i < address.length;i++){
                        System.out.print(address[i]);
                    }
                    System.out.println();
                    System.out.println();
                }

            }
            System.out.println();
            System.out.println();
        }

    }

}
