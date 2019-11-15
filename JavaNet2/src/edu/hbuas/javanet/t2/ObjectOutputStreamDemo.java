package edu.hbuas.javanet.t2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectOutputStreamDemo {

	public static void main(String[] args)  throws Exception{
		/**
		 *ObjectXXXStream���������߼�����=FileInputStream+DataInputStream+BufferedInputStream 
		 */
		
		
		/**
		 * ���л����ǽ��ڴ��е�Java���󱣴浽�ļ��У��򵥵����ݴ洢���ƣ�
		 */
		DownloadTask  t1=new DownloadTask("http://wexxxxx","΢�ŵ���",123132,"2019-11-15 12 :12 :12",12f);
		
		ObjectOutputStream  out=new ObjectOutputStream(new FileOutputStream("sources/1.ser"));
		out.writeObject(t1);
		out.flush();
		out.close();
		/**
		 * �����л����ǽ����ݴ�֮ǰ������ļ��л�ԭ���ڴ��е�һ��java������
		 */
		ObjectInputStream  in=new ObjectInputStream(new FileInputStream("sources/1.ser"));
		
		DownloadTask dt=(DownloadTask)in.readObject();
		dt.setPercent(78f);
		System.out.println(dt);
	}
}
