package edu.hbuas.javanet.t5.bradcast;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {

	public static void main(String[] args) throws Exception {
		
		//udp的服务端需要指定的一个端口
		//1.创建udp的socket对象，指定端口
		DatagramSocket  server=new DatagramSocket();
		

		
		//2.封装一个数据包裹，数据包裹里放入数据，准备发送出去
		byte[] message="你好，我是udp客户端".getBytes();
		InetAddress  address=InetAddress.getByName("255.255.255.255");//封装一个接收人地址类
		DatagramPacket  pack=new DatagramPacket(message,message.length,address,9999);
		
		//3.使用socket讲刚刚封装的数据包裹发送出去
		server.send(pack);
	}

}
