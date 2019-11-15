package edu.hbuas.javanet.t2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectOutputStreamDemo {

	public static void main(String[] args)  throws Exception{
		/**
		 *ObjectXXXStream过滤流（高级流）=FileInputStream+DataInputStream+BufferedInputStream 
		 */
		
		
		/**
		 * 序列化就是将内存中的Java对象保存到文件中（简单的数据存储机制）
		 */
		DownloadTask  t1=new DownloadTask("http://wexxxxx","微信电脑",123132,"2019-11-15 12 :12 :12",12f);
		
		ObjectOutputStream  out=new ObjectOutputStream(new FileOutputStream("sources/1.ser"));
		out.writeObject(t1);
		out.flush();
		out.close();
		/**
		 * 反序列化就是讲数据从之前保存的文件中还原到内存中的一个java对象中
		 */
		ObjectInputStream  in=new ObjectInputStream(new FileInputStream("sources/1.ser"));
		
		DownloadTask dt=(DownloadTask)in.readObject();
		dt.setPercent(78f);
		System.out.println(dt);
	}
}
