package edu.hbuas.javanet.t7;

public class MainThread {

	public static void main(String[] args) {
		Thread1  t1=new Thread1();
		t1.setName("first");
		t1.start();//启动线程调用的是start方法
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		Thread2 t2=new Thread2();
		Thread  tt2=new Thread(t2);
		tt2.setName("second");
		tt2.start();
		
		
		new Thread() {
			public void run() {
				for (int i = 0; i <10; i++) {
					System.out.println("%");
				}
			}
		}.start();
		
		for (int i = 0; i <10; i++) {
			System.out.println(i);
		}
	}
}


class  Thread1 extends Thread{
	@Override
	public void run() {
		try {
			sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
			for(int n=0;n<10;n++) {
				System.out.println("$");
			}
	}
}

class Thread2  implements Runnable{
	@Override
	public void run() {
		for(int n=0;n<10;n++) {
			System.out.println("*");
		}
	}
	
}