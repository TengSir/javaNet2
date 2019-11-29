package edu.hbuas.javanet.t4.file;

import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer {

	public static void main(String[] args) throws Exception {
		ServerSocket s = new ServerSocket(9000);

		while (true) {
			Socket client = s.accept();
			System.out.println(client.getInetAddress() + "链接进来了");
			OutputStream out = client.getOutputStream();

			// FIle IN SOcket Out

			FileInputStream in = new FileInputStream("D:\\abc.jpg");

			byte[] bs = new byte[1024 * 1024];
			int length = -1;
			while ((length = in.read(bs)) != -1) {
				out.write(bs, 0, length);
			}
			out.close();
			in.close();
			System.out.println(client.getInetAddress() + "文件发送成功");
		}
	}
}
