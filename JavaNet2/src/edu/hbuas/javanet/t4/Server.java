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
		//1.服务器 创建一个ServerSOcket对象，指定通讯端口
		ServerSocket  server=new ServerSocket(9000);
		System.out.println("服务器创建成功");
		//2.服务器对象调用accpet方法，表示可以接受一个人链接
		Socket client= server.accept();//阻塞方法（如果没有人链接，该方法将一直等待，）
		System.out.println(client.getInetAddress().getHostAddress());
		System.out.println("有一个人链接进来了");
		
		
		//为了能从服务器端读取用户在控制台输入的文字，我们需要获取控制台输入流
		//但是控制台输入流是个字节流，处理字符串不方便，所以我们二次包装成字符流
		
		BufferedReader  consoleReader=new BufferedReader(new InputStreamReader(System.in));
		
		//3.从socket通道里获取输入输出流
		BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
		BufferedReader reader=new BufferedReader(new InputStreamReader(client.getInputStream()));
		
		//-------------------------上面是建立socket链接并创建流---------------------------
		
		
		
		
		new Thread() {
			
			public void run() {
				while(true) {
					try {
						String message1=reader.readLine();
						System.out.println("客户端说："+message1);
					} catch (Exception e) {
						// TODO: handle exception
					}
					
				}
			};
		}.start();
		
		while(true) {
			
			
			System.out.println("请输入要发给客户端的语句：");
			String message=consoleReader.readLine();//阻塞方法
			writer.write(message);
			writer.newLine();//bufferwriter写数据，必须在一行内容后面加上换行符
			writer.flush();//清空缓存，强制将数据写入通道
		}
		
		//4.关闭流和网络socket对象
		//writer.close();
		
	}

}
