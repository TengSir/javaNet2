package edu.hbuas.javanet.t5;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {

	public static void main(String[] args) throws Exception {
		
		//udp的服务端需要指定的一个端口
		//1.创建udp的socket对象，指定端口
		DatagramSocket  server=new DatagramSocket(9999);
		
		//2.接受数据必须创建一个数据简报包裹对象
		byte[] data=new byte[1024];//真正存数据的字节数组
		DatagramPacket  pack=new DatagramPacket(data,data.length);
		
		//3.可以调用udp的socket对象的接手方法接受数据
		server.receive(pack);//阻塞的
		
		//4.具体业务（处理数据）
		System.out.println(new String(data));
		
		
		/**下面是给客户端回复消息**/
		byte[] sendMessage="你好，我是服务器，我给你回一句话".getBytes();
		DatagramPacket  sendPack=new DatagramPacket(sendMessage,sendMessage.length,pack.getAddress(),pack.getPort());
		
		
		server.send(sendPack);
		System.out.println( "发送完毕");
	}

}
