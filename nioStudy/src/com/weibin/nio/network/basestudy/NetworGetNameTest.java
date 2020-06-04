package com.weibin.nio.network.basestudy;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/1
 **/
public class NetworGetNameTest {

    public static void main(String[] args) throws SocketException {
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        while (networkInterfaces.hasMoreElements()){
            NetworkInterface networkInterface = networkInterfaces.nextElement();
            System.out.println("获取网络设备名称GetName() : " + networkInterface.getName());
            System.out.println("获取网络设备显示名称GetDisplayName() ： " + networkInterface.getDisplayName());
            System.out.println("获取网络接口的索引Getindex() : " + networkInterface.getIndex());
            System.out.println("网络接口是否开启并正常运行IsUp() : " + networkInterface.isUp());
            System.out.println("是否为回调接口IsLoopback() : " + networkInterface.isLoopback());
            System.out.println(" -------------------- END ----------------------");
        }


    }

}
