package edu.hbuas.javanet.t4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args)  throws Exception{
	//172.19.4.45
		//1.������ ����һ��ServerSOcket����ָ��ͨѶ�˿�
		ServerSocket  server=new ServerSocket(9000);
		System.out.println("�����������ɹ�");
		//2.�������������accpet��������ʾ���Խ���һ��������
		Socket client= server.accept();//�������������û�������ӣ��÷�����һֱ�ȴ�����
		System.out.println(client.getInetAddress().getHostAddress());
		System.out.println("��һ�������ӽ�����");
		
		
		//Ϊ���ܴӷ������˶�ȡ�û��ڿ���̨��������֣�������Ҫ��ȡ����̨������
		//���ǿ���̨�������Ǹ��ֽ����������ַ��������㣬�������Ƕ��ΰ�װ���ַ���
		
		BufferedReader  consoleReader=new BufferedReader(new InputStreamReader(System.in));
		
		//3.��socketͨ�����ȡ���������
		BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
		BufferedReader reader=new BufferedReader(new InputStreamReader(client.getInputStream()));
		
		//-------------------------�����ǽ���socket���Ӳ�������---------------------------
		
		
		
		
		new Thread() {
			
			public void run() {
				while(true) {
					try {
						String message1=reader.readLine();
						System.out.println("�ͻ���˵��"+message1);
					} catch (Exception e) {
						// TODO: handle exception
					}
					
				}
			};
		}.start();
		
		while(true) {
			
			
			System.out.println("������Ҫ�����ͻ��˵���䣺");
			String message=consoleReader.readLine();//��������
			writer.write(message);
			writer.newLine();//bufferwriterд���ݣ�������һ�����ݺ�����ϻ��з�
			writer.flush();//��ջ��棬ǿ�ƽ�����д��ͨ��
		}
		
		//4.�ر���������socket����
		//writer.close();
		
	}

}
