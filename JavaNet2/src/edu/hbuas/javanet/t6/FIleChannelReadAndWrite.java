package edu.hbuas.javanet.t6;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FIleChannelReadAndWrite {
	public static void main(String[] args)  throws Exception{
		
		FileChannel  read=FileChannel.open(Paths.get("sources/2.txt"), StandardOpenOption.READ);
		FileChannel  write=FileChannel.open(Paths.get("D:/2.txt"),StandardOpenOption.CREATE, StandardOpenOption.WRITE);

//		read.transferTo(0, read.size(), write);
		write.transferFrom(read, 0, read.size());
		
//�ֶ�����ͬ���е����ݣ�һ��һ����ȡ		
//		ByteBuffer  b=ByteBuffer.allocate(1024);
//		int length=-1;
//		while((length=read.read(b))!=-1) {
//			b.flip();
//			System.out.println("��һ�ζ�ȡ����"+length+"���ֽ�");
//				write.write(b);
//			b.clear();
//		}
		read.close();
		write.close();
	}

}
