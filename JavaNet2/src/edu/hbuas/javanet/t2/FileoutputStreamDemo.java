package edu.hbuas.javanet.t2;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class FileoutputStreamDemo {

	public static void main(String[] args) throws Exception {
		/**
		 * FileOutputStream���Խ��ֽ�����д���ļ�
		 * ���������Ĭ��д�����ݶ��Ǹ��ǣ������Ҫ׷�����ݣ���Ӧ���ڹ��������洫���ļ�֮�󣬶�һ������true
		 */
		OutputStream  out=new FileOutputStream("sources/1.txt",true);
		
		out.write(97);
		out.write("����һ�����룬����ʮ����".getBytes());
		
		out.close();

	}

}
