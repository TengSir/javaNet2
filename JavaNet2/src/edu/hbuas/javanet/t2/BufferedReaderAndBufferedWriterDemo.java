package edu.hbuas.javanet.t2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class BufferedReaderAndBufferedWriterDemo {
	
	
	public static void main(String[] args)  throws Exception{
		
		/**
		 *  BufferedReader 是过滤流
		 */
		BufferedReader   reader=new BufferedReader(new FileReader("sources/1.txt"));
		String oneLine=null;
		while((oneLine=reader.readLine())!=null) {
			System.out.println(oneLine);
		}
		/**
		 * BufferedWriter 是过滤流
		 */
		
		BufferedWriter writer=new BufferedWriter(new FileWriter("sources/1.txt",true));
		writer.write("阿闪大大大打算打打阿达收到");
		writer.newLine();
		writer.write("阿闪大大大打算打打阿达收到");
		writer.newLine();
		writer.write("阿闪大大大打算打打阿达收到");
		writer.newLine();
		writer.write("阿闪大大大打算打打阿达收到");
		writer.newLine();
		writer.flush();
		writer.close();
	}

}
