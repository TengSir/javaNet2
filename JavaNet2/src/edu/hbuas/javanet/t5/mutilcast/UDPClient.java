package edu.hbuas.javanet.t5.mutilcast;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class UDPClient {
	public static void main(String[] args) throws Exception {
		
		MulticastSocket  client=new MulticastSocket(9999);
		
		InetAddress  groupAddress=InetAddress.getByName("224.0.0.0");
		client.joinGroup(groupAddress);//��ǰsocket�����������鲥��ַ�������Ƶ�ν��ܻ�������
		
		byte[] data=new byte[100];
		DatagramPacket  pack=new DatagramPacket(data, data.length);
		
		client.receive(pack);
		
		System.out.println(new String(data));
	}

}
