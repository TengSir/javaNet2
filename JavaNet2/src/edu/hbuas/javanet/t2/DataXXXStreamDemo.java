package edu.hbuas.javanet.t2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DataXXXStreamDemo {

	public static void main(String[] args)  throws Exception{
		// TODO Auto-generated method stub
		/**
		 * �߼���,��������԰��ֻ������ͺ�String����д����
		 * 
		 * DataXXXStream�����ṩ�ķ���������԰��ֻ�����������+String��д
		 */
		
		DataOutputStream  dout=new DataOutputStream(new FileOutputStream("sources/3.txt"));
		dout.writeInt(1);
		dout.flush();
		dout.close();
		
		DataInputStream  diut=new DataInputStream(new FileInputStream("sources/3.txt"));
		System.out.println(diut.readInt());

	}

}
