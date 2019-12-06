package edu.hbuas.javanet.t5.mutilcast;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class UDPServer {

	public static void main(String[] args) throws Exception {
			MulticastSocket  server=new MulticastSocket();
			
			InetAddress  groupAddress=InetAddress.getByName("224.0.0.0");
			server.joinGroup(groupAddress);//��ǰsocket�����������鲥��ַ�������Ƶ�ν��ܻ�������
			
			byte[] data="��ã������鲥".getBytes();
			DatagramPacket  pack=new DatagramPacket(data, data.length,groupAddress,9999);
			
			server.setBroadcast(true);
			server.send(pack);
	}

}
