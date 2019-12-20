package edu.hbuas.javanet.t7;

public class Ticket {
	
	private int  num=1;
	
	public synchronized void sellTicket(String windowname) {
		if(num>100) {
			System.out.println("票售完了");
		}else {
			System.out.println(windowname+"窗口卖出了编号为"+num+"的票");
			num++;
		}
	}
	
	public synchronized int getNum() {
		return num;
	}

}
