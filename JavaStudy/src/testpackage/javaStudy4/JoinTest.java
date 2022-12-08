package testpackage.javaStudy4;

public class JoinTest {
	public static void main(String[] args) {
		GarbageCollect gcThread = new GarbageCollect();
		gcThread.setDaemon(true);
		gcThread.start();
		
		int requiredMemory = 0;
		
		for(int i=0; i<20; i++) {
			requiredMemory = (int)(Math.random()*10) * 20;
			
			if(gcThread.freeMemory() < requiredMemory || gcThread.freeMemory() < gcThread.totalMemory()*0.4) {
				gcThread.interrupt();
				try {
					gcThread.join(100);
				}catch (InterruptedException ie) {
					System.out.println("gcThread join finish!!!!!!!!!!!!");
				}
			}
			
			gcThread.usedMemory += requiredMemory;
			System.out.println(gcThread.usedMemory);
		}
	}
}

class GarbageCollect extends Thread {
	final static int MAX_MEMORY = 1000;
	int usedMemory = 0;
	
	public void run() {
		while(true) {
			try {
				Thread.sleep(10 * 1000);
			} catch(InterruptedException ie) {
				System.out.println("AWAKEN!!!!!!!!!!!!!");
			}
			
			gc();
			System.out.println("Garbage Collected. Free Memory : " + freeMemory());
		}
	}
	
	public void gc() {
		usedMemory -= 300;
		if(usedMemory < 0) usedMemory = 0;
	}
	
	public int totalMemory() {return MAX_MEMORY;}
	public int freeMemory() { return MAX_MEMORY - usedMemory;}
}