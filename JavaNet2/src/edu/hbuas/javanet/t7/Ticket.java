package edu.hbuas.javanet.t7;

public class Ticket {
	
	private int  num=1;
	
	public synchronized void sellTicket(String windowname) {
		if(num>100) {
			System.out.println("Ʊ������");
		}else {
			System.out.println(windowname+"���������˱��Ϊ"+num+"��Ʊ");
			num++;
		}
	}
	
	public synchronized int getNum() {
		return num;
	}

}
