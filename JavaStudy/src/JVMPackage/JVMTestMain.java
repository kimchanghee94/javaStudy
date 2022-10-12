package JVMPackage;

import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.FileOutputStream;
import java.io.IOException;

public class JVMTestMain {
	public static void main(String[] args)  throws InterruptedException{
		BufferedOutputStream bos = null;
		try {
			FileOutputStream fos = new FileOutputStream("dest.txt");
			bos = new BufferedOutputStream(fos, 10000);

			Runtime.getRuntime().gc();
			long usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
			System.out.println(usedMemory + " bytes");
			bos.close();
			System.out.println(fos.getChannel());
			usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
			System.out.println(usedMemory + " bytes");
			bos = null;
			fos = null;
//			System.out.println("====================AFTER========================");
//			for(int i=0; i<1000000; i++) {
//				new TestInstance();				
//				usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
//				System.out.println(usedMemory + " bytes");
//			}
//			bos.write(1);
			Thread.sleep(1);
			System.out.println("finish");
		} catch (IOException e) {
			e.printStackTrace();
		}
		try(TestInstance t = new TestInstance()){
			t.method();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}	
}

class TestInstance implements Closeable{
	int a;;
	int b;
	int[] arr = new int[100000];

	void method() {
		System.out.println("hi");
	}
	
	@Override
	public void close() throws IOException{
		System.out.println("finish");
	}
}
