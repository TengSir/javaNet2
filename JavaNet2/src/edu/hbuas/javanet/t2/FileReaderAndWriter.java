package edu.hbuas.javanet.t2;

import java.io.FileReader;
import java.io.FileWriter;

public class FileReaderAndWriter {

	public static void main(String[] args)  throws Exception{
		/**
		 * FileReader��FileWriter��ר������ļ����ַ����������
		 */
		
		FileReader reader=new FileReader("sources/1.txt");
		char[] bs=new char[100];
		int length=-1;
		while((length=reader.read(bs))!=-1) {
			System.out.println(new String(bs));
		}

		
		/**
		 * FileWriter����ֱ�ӽ��ַ�д���ļ�
		 */
		
		FileWriter writer =new FileWriter("sources/1.txt",true);
		writer.write("��");
		writer.write(new char[] {'��','��'});
		writer.write("��˭");
		writer.close();
	}

}
