package edu.hbuas.javanet.t7;

import java.util.Random;

public class SellTicketDemo {
	public static void main(String[] args) {
		
		Ticket  t=new Ticket();
		Thread t1=new Thread() {
			public void run() {
				while(t.getNum()<=100) {
					try {
						Thread.sleep(new Random().nextInt(10)*1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					t.sellTicket("A");
				}
			}
		};
		t1.start();
		
		Thread t2=new Thread() {
			public void run() {
				while(t.getNum()<=100) {
					try {
						Thread.sleep(new Random().nextInt(10)*1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					t.sellTicket("B");
				}
			}
		};
		t2.start();
	}

}
