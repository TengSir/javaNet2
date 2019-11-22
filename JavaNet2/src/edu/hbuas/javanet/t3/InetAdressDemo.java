package edu.hbuas.javanet.t3;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAdressDemo {
	
	public static void main(String[] args) {
		try {
			InetAddress  inet=InetAddress.getByName("www.baidu.com");
			InetAddress[]  inets=InetAddress.getAllByName("www.baidu.com");
			for(InetAddress  i:inets) {
				System.out.println(i.getHostAddress());
			}
		
			System.out.println(inet.getHostAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
