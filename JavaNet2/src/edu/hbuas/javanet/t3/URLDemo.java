package edu.hbuas.javanet.t3;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class URLDemo {
	public static void main(String[] args) throws Exception {
//		URL  u=new URL("http://103.235.46.39/");
//		
//		InputStream in=u.openStream();
//		
//		
//		BufferedReader  reader=new BufferedReader(new InputStreamReader(in));
//		
//		String message=null;
//		while((message=reader.readLine())!=null) {
//			System.out.println(message);
//		}
//		
		
		URL  img=new URL("https://pacakge.cache.wpscdn.cn/wps/download/W.P.S.9208.12012.2019.exe");
		
		InputStream  in=img.openStream();
		
		FileOutputStream  out=new FileOutputStream("D:\\123\\1.exe");
		
		byte[] bs=new byte[1024*1024*200];
		int lenth=-1;
		while((lenth=in.read(bs))!=-1) {
			System.out.println(lenth);
			out.write(bs,0,lenth);
		}
		out.flush();
		out.close();
		in.close();
		
		
		
	}

}
