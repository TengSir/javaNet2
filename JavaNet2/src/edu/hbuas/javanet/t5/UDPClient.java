package edu.hbuas.javanet.t5;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
	
	public static void main(String[] args) throws Exception {
		//udp的客户端也是创建一个socket对象，然后封装一个数据包裹，发送出去
		
		//1.创建一个udp的socket对象，可以指定端口也可以不指定
		DatagramSocket  client=new DatagramSocket(9998);
		
		//2.封装一个数据包裹，数据包裹里放入数据，准备发送出去
		byte[] message="你好，我是udp客户端".getBytes();
		InetAddress  address=InetAddress.getByName("localhost");//封装一个接收人地址类
		DatagramPacket  pack=new DatagramPacket(message,message.length,address,9999);
		
		//3.使用socket讲刚刚封装的数据包裹发送出去
		client.send(pack);
		
		System.out.println("发送完毕");
		
		
	  /**下面是接受服务端发过来的消息代码****/
		byte[] reciveData=new byte[100];
		DatagramPacket  recivePack=new DatagramPacket(reciveData, reciveData.length);
		
		client.receive(recivePack);
		
		System.out.println(new String(reciveData));
		
	}

}
