package edu.hbuas.javanet.t4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {

	public static void main(String[] args) throws Exception{
	  //1.����һ��socket����ָ��Ҫ���ӵķ�������ַ�Ͷ˿�
		Socket client=new Socket("172.19.4.45", 9000);//
		System.out.println("�Ѿ����ӵ���������");
		
		//Ϊ���ܴӷ������˶�ȡ�û��ڿ���̨��������֣�������Ҫ��ȡ����̨������
		//���ǿ���̨�������Ǹ��ֽ����������ַ��������㣬�������Ƕ��ΰ�װ���ַ���
		
		BufferedReader  consoleReader=new BufferedReader(new InputStreamReader(System.in));
		
		//2.��socketͨ�����ȡ���������
				BufferedReader reader=new BufferedReader(new InputStreamReader(client.getInputStream()));
	          BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
				
	          
	     //--------------------�����ǽ���socket���Ӳ�������-------------------------------- 
	          
	          
	      	new Thread() {
				
				public void run() {
					while(true) {
						try {

			        	    System.out.println("������Ҫ��������˵���䣺");
			    	  		String message1=consoleReader.readLine();//��������
			    	  		writer.write(message1);
			    	  		writer.newLine();
			    	  		writer.flush();
						} catch (Exception e) {
						}
						
					}
				};
			}.start();
	          
	          while(true) {
	        	  
				    String  message=reader.readLine();//��������
			         System.out.println("������˵��"+message);
				}
				
	     
	     	//3.�ر���������socket����
	 		//reader.close();
	         
	         
	
	}

}
