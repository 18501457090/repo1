package com.weibin.nio.network.basestudy;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/1
 **/
public class NetworkHardwareAddressTest {

    public static void main(String[] args) throws SocketException {
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        while (networkInterfaces.hasMoreElements()){
            NetworkInterface networkInterface = networkInterfaces.nextElement();
            System.out.println("获取网络设备名称：" + networkInterface.getName());
            System.out.println("获取网络设备显示名称：" + networkInterface.getDisplayName());
            byte[] hardwareAddress = networkInterface.getHardwareAddress();
            if (hardwareAddress != null && hardwareAddress.length > 0){
                System.out.print("获得网卡的物理地址：" );
                for (int i = 0; i < hardwareAddress.length;i++){
                    System.out.print(hardwareAddress[i] + " ");
                }
                System.out.println();
            }
            System.out.println();
            System.out.println();

        }

    }

}
