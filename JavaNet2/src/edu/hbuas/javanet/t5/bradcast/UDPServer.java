package edu.hbuas.javanet.t5.bradcast;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {

	public static void main(String[] args) throws Exception {
		
		//udp�ķ������Ҫָ����һ���˿�
		//1.����udp��socket����ָ���˿�
		DatagramSocket  server=new DatagramSocket();
		

		
		//2.��װһ�����ݰ��������ݰ�����������ݣ�׼�����ͳ�ȥ
		byte[] message="��ã�����udp�ͻ���".getBytes();
		InetAddress  address=InetAddress.getByName("255.255.255.255");//��װһ�������˵�ַ��
		DatagramPacket  pack=new DatagramPacket(message,message.length,address,9999);
		
		//3.ʹ��socket���ոշ�װ�����ݰ������ͳ�ȥ
		server.send(pack);
	}

}
