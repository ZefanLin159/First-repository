package com.MyInternet;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InternetAddDemo {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getByName("192.168.184.1");
        String hostName = address.getHostName();
        String ip = address.getHostAddress();
        System.out.println(hostName);
        System.out.println(ip);
    }
}
