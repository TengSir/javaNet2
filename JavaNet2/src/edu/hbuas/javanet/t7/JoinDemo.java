package edu.hbuas.javanet.t7;

import java.util.ArrayList;

public class JoinDemo {
	public static void main(String[] args) {
		final ArrayList<Integer>  nums=new ArrayList<Integer>();
		
		Thread t1=new Thread() {
			public void run() {
				for (int i = 0; i <10; i++) {
					nums.add(i);
				}
			}
		};
		t1.start();
		try {
			t1.join(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(nums.size());
		
		
//		Thread t1=new Thread() {
//			public void run() {
//				for (int i = 0; i <10; i++) {
//					System.out.println("%");
//				}
//			}
//		};
//		
//		Thread t2=new Thread() {
//			public void run() {
//				for (int i = 0; i <10; i++) {
//					System.out.println("$");
//				}
//			}
//		};
//		
//		t1.start();
//		try {
//			t1.join();//ÈÃ²½
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		
//		
//		t2.start();
	}

}
