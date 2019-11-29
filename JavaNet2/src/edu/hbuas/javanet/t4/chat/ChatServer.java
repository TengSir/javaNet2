package edu.hbuas.javanet.t4.chat;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;

public class ChatServer {
	ServerSocket serverSocket;
	ArrayList<BufferedReader> ins=new ArrayList<BufferedReader>();
	ArrayList<PrintWriter> outs=new ArrayList<PrintWriter>();
	LinkedList<String> msgList=new LinkedList<String>();
	
	public ChatServer(){
		try {
			serverSocket=new ServerSocket(8888);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//创建AcceptSocketThread线程，并启动
		new AcceptSocketThread().start();
		//创建SendMsgToClient线程，并启动
		new SendMsgToClient().start();
		System.out.println("Server Start...");
	}
	//接收客户端套接字线程
	class AcceptSocketThread extends Thread{
		public void run(){
			while(this.isAlive()){
				try {
					//接收套接字
					Socket socket=serverSocket.accept();
					if(socket!=null){
						BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
						ins.add(in);
						outs.add(new PrintWriter(socket.getOutputStream()));
						//开启一个线程接收客户端的聊天信息
						new GetMsgFromClient(in).start();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}
	}
	// 接收客户的聊天信息的线程
	class GetMsgFromClient extends Thread {
		BufferedReader in;
		public GetMsgFromClient(BufferedReader in){
				this.in=in;	
		}
		public void run() {
			while (this.isAlive()) {
				try {
					String strMsg = in.readLine();
					if (strMsg != null) {
						msgList.addFirst(strMsg);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	//给所有客户发送聊天信息的线程
	class SendMsgToClient extends Thread{
		public void run(){
			while(this.isAlive()){
				try {
					if(!msgList.isEmpty()){
						String s=msgList.removeLast();
						for(int i=0;i<outs.size();i++){
							outs.get(i).println(s);
							outs.get(i).flush();
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String args[]) {
		new ChatServer();
	}
}
