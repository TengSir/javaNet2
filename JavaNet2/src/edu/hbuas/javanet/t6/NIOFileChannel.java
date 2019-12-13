package edu.hbuas.javanet.t6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class NIOFileChannel {
	public static void main(String[] args) {
		//NIO�ж��ļ��Ķ�д����ȫ��ʹ��FIleChanel(ͨ����˫��ģ�����û����ν����������)
		
		//FIleChannel�Ĵ򿪷�ʽ������
		//1.FileChannel������һ��open����������ֱ�Ӵ�һ���ļ�ͨ��
		
		try {
			FileChannel  c=FileChannel.open(Paths.get("sources/1.txt"), StandardOpenOption.WRITE,StandardOpenOption.READ);
			ByteBuffer  b=ByteBuffer.allocate(100);
			System.out.println(b.position());
			int length=c.read(b);
			System.out.println(b.position());
			b.flip();//�����ݴ��뻺����֮�����Ҫ�������������������ִ�з�ת
			byte[] bs=new byte[100];
			b.get(bs);
			b.flip();//�����ݴ��뻺����֮�����Ҫ�������������������ִ�з�ת
			System.out.println(new String(bs));
			c.write(b);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//2.java�ײ���κ�һ��io����ֱ���ṩ��ת����channel�ķ���
		try {
			FileInputStream  in=new FileInputStream("sources/1.txt");
			FileChannel  c1=in.getChannel();
			FileOutputStream  out=new FileOutputStream("sources/1.txt");
			FileChannel  c2=out.getChannel();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
