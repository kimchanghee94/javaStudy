package testpackage.javaStudy4;

public class ProcessThread {
	public static void main(String[] args) {
		ThreadEx1 t1 = new ThreadEx1();
		Thread t2 = new Thread(new ThreadEx2(), "내가 직접 runnable형태로 만들어봄");
		t1.setPriority(5);
		
		System.out.println("t1 priority : " + t1.getPriority());
		System.out.println("t2 priority : " + t2.getPriority());
		t1.start();
		t2.start();	
	}
}

class ThreadEx1 extends Thread{
	public void run() {
		System.out.println(getName());
		for(int i=0; i<300; i++) {
			System.out.print("-");
		}
	}
}

class ThreadEx2 implements Runnable{
	public void run() {
		System.out.println(Thread.currentThread().getName());
		for(int i=0; i<300; i++) {
			System.out.print("|");
		}
	}
}