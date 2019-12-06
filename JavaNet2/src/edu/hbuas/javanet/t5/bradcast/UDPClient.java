package edu.hbuas.javanet.t5.bradcast;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
	
	public static void main(String[] args) throws Exception {
		//udp的客户端也是创建一个socket对象，然后封装一个数据包裹，发送出去
		
		//1.创建一个udp的socket对象，可以指定端口也可以不指定
		DatagramSocket  client=new DatagramSocket(9999);
		
		//2.接受数据必须创建一个数据简报包裹对象
		byte[] data=new byte[1024];//真正存数据的字节数组
		DatagramPacket  pack=new DatagramPacket(data,data.length);
		
		//3.可以调用udp的socket对象的接手方法接受数据
		client.receive(pack);//阻塞的
		
		//4.具体业务（处理数据）
		System.out.println(new String(data));
	
	
		
	}

}
