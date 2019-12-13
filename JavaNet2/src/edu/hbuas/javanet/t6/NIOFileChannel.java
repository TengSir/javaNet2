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
		//NIO中对文件的读写操作全部使用FIleChanel(通道是双向的，所以没有所谓的输入和输出)
		
		//FIleChannel的打开方式有两种
		//1.FileChannel类中有一个open方法，可以直接打开一个文件通道
		
		try {
			FileChannel  c=FileChannel.open(Paths.get("sources/1.txt"), StandardOpenOption.WRITE,StandardOpenOption.READ);
			ByteBuffer  b=ByteBuffer.allocate(100);
			System.out.println(b.position());
			int length=c.read(b);
			System.out.println(b.position());
			b.flip();//将数据存入缓存区之后如果要从里面读出来，必须先执行翻转
			byte[] bs=new byte[100];
			b.get(bs);
			b.flip();//将数据存入缓存区之后如果要从里面读出来，必须先执行翻转
			System.out.println(new String(bs));
			c.write(b);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//2.java底层的任何一个io流都直接提供了转化成channel的方法
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
