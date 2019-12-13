package edu.hbuas.javanet.t6;

import java.nio.ByteBuffer;

public class Bufferdemo {
	
	public static void main(String[] args) {
		ByteBuffer  b=ByteBuffer.allocate(100);
		
		
		byte[] bs="你好，buffer".getBytes();
		
		ByteBuffer  b1=ByteBuffer.wrap(bs);
		b.put(bs);
		b.flip();//当数据放入缓存完毕后，准备开始读的时候调用一下，会自动将位置和限制设置到合理的位置
		System.out.println(b.capacity());
		System.out.println(b.limit());
		System.out.println(b.position());
	}

}
