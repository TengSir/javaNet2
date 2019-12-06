package edu.hbuas.javanet.t5;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {

	public static void main(String[] args) throws Exception {
		
		//udp�ķ������Ҫָ����һ���˿�
		//1.����udp��socket����ָ���˿�
		DatagramSocket  server=new DatagramSocket(9999);
		
		//2.�������ݱ��봴��һ�����ݼ򱨰�������
		byte[] data=new byte[1024];//���������ݵ��ֽ�����
		DatagramPacket  pack=new DatagramPacket(data,data.length);
		
		//3.���Ե���udp��socket����Ľ��ַ�����������
		server.receive(pack);//������
		
		//4.����ҵ�񣨴������ݣ�
		System.out.println(new String(data));
		
		
		/**�����Ǹ��ͻ��˻ظ���Ϣ**/
		byte[] sendMessage="��ã����Ƿ��������Ҹ����һ�仰".getBytes();
		DatagramPacket  sendPack=new DatagramPacket(sendMessage,sendMessage.length,pack.getAddress(),pack.getPort());
		
		
		server.send(sendPack);
		System.out.println( "�������");
	}

}
