package edu.hbuas.javanet.t2;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

public class BufferedOutputStreamDemo {

	public static void main(String[] args)  throws Exception{
		// TODO Auto-generated method stub
		/**
		 * 
		 * BufferexxxStream��FileXXStream������ûʲô����Ψһ������������������ʹ�û�������߶�дЧ��
		 * 
		 * 
		 * BufferedOutputStream���������ʹ�û��棨�ڴ��ݴ�ռ䣩
		 * 
		 * BufferedOutputStreamÿ�ε���write������д�����ݲ���������д���ļ���д���ڴ滺��ռ�
		 * �ȵ��û������������flush����������close����ʱ�ŻὫ���ݴӻ��泹��д���ļ�
		 */
		
//		BufferedOutputStream  out=new BufferedOutputStream(new FileOutputStream("sources/2.txt"));
		FileOutputStream  out=new FileOutputStream("sources/2.txt");
		
		while(true) {
			Thread.sleep(4000);
			out.write(97);
			out.flush();
			System.out.println("wirte one byte");
		}

	}

}
