package edu.hbuas.javanet.t2;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class BufferedInputstreamDemo {

	public static void main(String[] args)  throws Exception{
		// TODO Auto-generated method stub
		/***
		 * BufferedInputstream��Fileinputstream�����ݵķ���һģһ��
		 * �������������ʹ�û������ݴ����ݣ�ֻ��������������
		 */
		
		BufferedInputStream  in=new BufferedInputStream(new FileInputStream("sources/1.txt"));
		
		in.read();

	}

}
