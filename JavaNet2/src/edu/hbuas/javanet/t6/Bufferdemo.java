package edu.hbuas.javanet.t6;

import java.nio.ByteBuffer;

public class Bufferdemo {
	
	public static void main(String[] args) {
		ByteBuffer  b=ByteBuffer.allocate(100);
		
		
		byte[] bs="��ã�buffer".getBytes();
		
		ByteBuffer  b1=ByteBuffer.wrap(bs);
		b.put(bs);
		b.flip();//�����ݷ��뻺����Ϻ�׼����ʼ����ʱ�����һ�£����Զ���λ�ú��������õ������λ��
		System.out.println(b.capacity());
		System.out.println(b.limit());
		System.out.println(b.position());
	}

}
