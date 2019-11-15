package edu.hbuas.javanet.t2;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileReadAndWriteDemo {

	public static void main(String[] args) throws Exception {

		/**
		 * ʹ���ļ��ֽ�������������һ���ļ����и��Ʋ���
		 */
		FileInputStream source=new FileInputStream("sources/1.txt");
		
		FileOutputStream dest=new FileOutputStream("d:/1.txt");
		byte[] bs=new byte[1024*1024*10];
		int length=-1;
		while((length=source.read(bs))!=-1) {
			dest.write(bs,0,length);
			System.out.println(length);
		}
		
		source.close();
		dest.close();
		
	}

}
