package testpackage.javaStudy4;

public class ThreadSleep {
	public static void main(String[] args) {
		ThreadSleep1 t1 = new ThreadSleep1();
		Thread t2 = new Thread(new ThreadSleep2());
		
		
		t1.start();
		t2.start();
		
		try {
			Thread.sleep(1000);
		}catch(InterruptedException ie) {
			ie.printStackTrace();
		}
		
		System.out.println("main method stop");
	}
}

class ThreadSleep1 extends Thread {
	public void run() {
		try {
			Thread.sleep(2000);
			System.out.println("Thread Sleep1 stop");
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}
}

class ThreadSleep2 implements Runnable {
	public void run() {
		System.out.println("Thread Sleep2 stop");

	}
}