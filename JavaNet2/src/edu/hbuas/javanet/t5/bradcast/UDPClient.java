package edu.hbuas.javanet.t5.bradcast;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
	
	public static void main(String[] args) throws Exception {
		//udp�Ŀͻ���Ҳ�Ǵ���һ��socket����Ȼ���װһ�����ݰ��������ͳ�ȥ
		
		//1.����һ��udp��socket���󣬿���ָ���˿�Ҳ���Բ�ָ��
		DatagramSocket  client=new DatagramSocket(9999);
		
		//2.�������ݱ��봴��һ�����ݼ򱨰�������
		byte[] data=new byte[1024];//���������ݵ��ֽ�����
		DatagramPacket  pack=new DatagramPacket(data,data.length);
		
		//3.���Ե���udp��socket����Ľ��ַ�����������
		client.receive(pack);//������
		
		//4.����ҵ�񣨴������ݣ�
		System.out.println(new String(data));
	
	
		
	}

}
