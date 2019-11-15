package edu.hbuas.javanet.t2;

import java.io.FileReader;
import java.io.FileWriter;

public class FileReaderAndWriter {

	public static void main(String[] args)  throws Exception{
		/**
		 * FileReader和FileWriter是专门针对文件的字符输入输出流
		 */
		
		FileReader reader=new FileReader("sources/1.txt");
		char[] bs=new char[100];
		int length=-1;
		while((length=reader.read(bs))!=-1) {
			System.out.println(new String(bs));
		}

		
		/**
		 * FileWriter可以直接将字符写入文件
		 */
		
		FileWriter writer =new FileWriter("sources/1.txt",true);
		writer.write("你");
		writer.write(new char[] {'你','好'});
		writer.write("是谁");
		writer.close();
	}

}
