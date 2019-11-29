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
	  //1.创建一个socket对象，指明要链接的服务器地址和端口
		Socket client=new Socket("172.19.4.45", 9000);//
		System.out.println("已经链接到服务器了");
		
		//为了能从服务器端读取用户在控制台输入的文字，我们需要获取控制台输入流
		//但是控制台输入流是个字节流，处理字符串不方便，所以我们二次包装成字符流
		
		BufferedReader  consoleReader=new BufferedReader(new InputStreamReader(System.in));
		
		//2.从socket通道里获取输入输出流
				BufferedReader reader=new BufferedReader(new InputStreamReader(client.getInputStream()));
	          BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
				
	          
	     //--------------------上面是建立socket链接并创建流-------------------------------- 
	          
	          
	      	new Thread() {
				
				public void run() {
					while(true) {
						try {

			        	    System.out.println("请输入要发给服务端的语句：");
			    	  		String message1=consoleReader.readLine();//阻塞方法
			    	  		writer.write(message1);
			    	  		writer.newLine();
			    	  		writer.flush();
						} catch (Exception e) {
						}
						
					}
				};
			}.start();
	          
	          while(true) {
	        	  
				    String  message=reader.readLine();//阻塞方法
			         System.out.println("服务器说："+message);
				}
				
	     
	     	//3.关闭流和网络socket对象
	 		//reader.close();
	         
	         
	
	}

}
