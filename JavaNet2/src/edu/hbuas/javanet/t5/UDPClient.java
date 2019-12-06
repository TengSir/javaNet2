package edu.hbuas.javanet.t5;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
	
	public static void main(String[] args) throws Exception {
		//udp�Ŀͻ���Ҳ�Ǵ���һ��socket����Ȼ���װһ�����ݰ��������ͳ�ȥ
		
		//1.����һ��udp��socket���󣬿���ָ���˿�Ҳ���Բ�ָ��
		DatagramSocket  client=new DatagramSocket(9998);
		
		//2.��װһ�����ݰ��������ݰ�����������ݣ�׼�����ͳ�ȥ
		byte[] message="��ã�����udp�ͻ���".getBytes();
		InetAddress  address=InetAddress.getByName("localhost");//��װһ�������˵�ַ��
		DatagramPacket  pack=new DatagramPacket(message,message.length,address,9999);
		
		//3.ʹ��socket���ոշ�װ�����ݰ������ͳ�ȥ
		client.send(pack);
		
		System.out.println("�������");
		
		
	  /**�����ǽ��ܷ���˷���������Ϣ����****/
		byte[] reciveData=new byte[100];
		DatagramPacket  recivePack=new DatagramPacket(reciveData, reciveData.length);
		
		client.receive(recivePack);
		
		System.out.println(new String(reciveData));
		
	}

}
