package edu.hbuas.javanet.t2;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class BufferedInputstreamDemo {

	public static void main(String[] args)  throws Exception{
		// TODO Auto-generated method stub
		/***
		 * BufferedInputstream和Fileinputstream读数据的方法一模一样
		 * 但是这个流可以使用缓存来暂存数据，只有输出才能用输出
		 */
		
		BufferedInputStream  in=new BufferedInputStream(new FileInputStream("sources/1.txt"));
		
		in.read();

	}

}
