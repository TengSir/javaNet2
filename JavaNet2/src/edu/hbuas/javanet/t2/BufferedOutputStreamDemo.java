package edu.hbuas.javanet.t2;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

public class BufferedOutputStreamDemo {

	public static void main(String[] args)  throws Exception{
		// TODO Auto-generated method stub
		/**
		 * 
		 * BufferexxxStream和FileXXStream方法上没什么区别，唯一的区别就是这个流可以使用缓存来提高读写效率
		 * 
		 * 
		 * BufferedOutputStream这个流可以使用缓存（内存暂存空间）
		 * 
		 * BufferedOutputStream每次调用write方法，写入数据并不是立马写入文件，写入内存缓存空间
		 * 等到用户调用这个流的flush方法，或者close方法时才会将数据从缓存彻底写入文件
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
