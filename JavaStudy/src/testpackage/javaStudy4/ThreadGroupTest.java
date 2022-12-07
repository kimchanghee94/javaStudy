package testpackage.javaStudy4;

public class ThreadGroupTest {
	public static void main(String[] args) {
		ThreadGroup main = Thread.currentThread().getThreadGroup();
		ThreadGroup grp1 = new ThreadGroup("Group1");
		ThreadGroup grp2 = new ThreadGroup("Group2");
		
		grp1.setMaxPriority(3);
		ThreadGroup subGrp1 = new ThreadGroup(grp1, "Sub Group1¿‘¥œ¥Ÿ.");
		
		Runnable r = new Runnable() {
			public void run() {
				try {
					Thread.sleep(1000);
				} catch(InterruptedException ie) {
					ie.printStackTrace();
				}
			}
		};
		
		new Thread(grp1, r, "th1").start();
		new Thread(grp2, r, "th2").start();
		new Thread(subGrp1, r, "th1_1").start();
		
		System.out.println(main.getName() +"," + main.activeGroupCount() + ", " + main.activeCount());
		main.list();
	}
}


