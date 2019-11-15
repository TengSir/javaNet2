package edu.hbuas.javanet.t2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Date;

public class ConsoleIO {
	public static void main(String[] args) throws Exception {
		//Java将System.out设置为标准输出
		//Java将System.in设置为标准输入
		
		//控制台I，文件O
		
		BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("sources/chat.txt")));
		
		InputStream  in=System.in;
		BufferedReader  reader=new BufferedReader(new InputStreamReader(in));
		
		String oneLine=null;
		while((oneLine=reader.readLine())!=null) {
			System.out.println(oneLine);
			writer.write(new Date().toLocaleString()+"  :  "+oneLine);
			writer.newLine();
			writer.flush();
		}
	}

}
