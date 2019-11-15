package edu.hbuas.javanet.t2;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class FileoutputStreamDemo {

	public static void main(String[] args) throws Exception {
		/**
		 * FileOutputStream可以将字节数据写入文件
		 * 所有输出流默认写入数据都是覆盖，如果想要追加内容，则应该在构造器后面传入文件之后，多一个参数true
		 */
		OutputStream  out=new FileOutputStream("sources/1.txt",true);
		
		out.write(97);
		out.write("我有一个梦想，挣他十个亿".getBytes());
		
		out.close();

	}

}
