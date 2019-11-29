package edu.hbuas.javanet.t4.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.Socket;

public class FileClient {
	public static void main(String[] args)  throws Exception{
		Socket  client=new Socket("172.19.4.45",9000);
		System.out.println("链接服务器成功");
		InputStream  in=client.getInputStream();
		// Socket In  File out
		
		FileOutputStream  out=new FileOutputStream("D:\\test.jpg");
		
		byte[] bs=new byte[1024*1024];
		int length=-1;
		while((length=in.read(bs))!=-1) {
			out.write(bs,0,length);
		}
		out.close();
		in.close();
		System.out.println("文件接收成功");
	}
}
