package edu.hbuas.javanet.t2;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;

public class FileInputStreamDemo {

	public static void main(String[] args) throws Exception{
		
//		InputStream  in=new FileInputStream(new File("sources/default.jpg"));
		/**
		 * 使用文件字节输入流一个个字节读取一个文件的代码结构
		 */
//		System.out.println(new String(new byte[] {(byte)196,(byte)227}));
//		InputStream  in=new FileInputStream("D:\\1.mp4");
//		int byteCode=-1;
//		while((byteCode=in.read())!=-1) {
//			System.out.println(byteCode);
//		}
		
		/**
		 * 使用文件字节输入流一次性读取一个数组的字节读取一个文件的代码结构
		 */
//		System.out.println(new String(new byte[] {(byte)196,(byte)227}));
		InputStream  in=new FileInputStream("D:\\1.mp4");
		byte[] bs=new byte[1024*50];
		int length=-1;
		while((length=in.read(bs))!=-1) {
//			System.out.println(Arrays.toString(bs));
			System.out.println(length);
		}
		
		in.close();

	}

}
