package testpackage.javaStudy2;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionTest {
	public static void main(String[] args) throws FileNotFoundException {
		try {
			System.out.println(0);
		}catch(ArithmeticException e) {
			e = (ArithmeticException) new Exception();
		}
		
		ChildException ce = new ChildException();
		System.out.println(ce.method());
		
		TryWithResource.method();
		
		try {
			ThrowMethod();			
		} catch(RuntimeException re) {
			re.printStackTrace();	
		}
		
	}
	
	static int ThrowMethod() throws RuntimeException{
		throw new RuntimeException(new MyException("chained exception Test"));
	}
}

class ParentExcetion{
	public int method() throws ArithmeticException{
		return 2;
	}
}

class ChildException extends ParentExcetion{
	
	public int method() throws RuntimeException{
		try {
			return 1;
		}catch(Exception e) {
			e.printStackTrace();
			return 2;
		}finally {
			
		}
	}
}

class TryWithResource{
	public static void method() {
		try {
			try {
				throw new MyException("TestExceptionEEEEEEEEE", 232);
			}catch (MyException me) {
				System.out.println(me.getMessage());
				me.printStackTrace();
			}
			throw new IOException();
		} catch(IOException ie) {
			System.out.println("FIRST");
//			throw new FileNotFoundException();
		}/*catch (FileNotFoundException fe) {
			
		}*/
		
		/* finally {
			try {
				throw new IOException();
			} catch (IOException ie) {
				System.out.println("SECOND");
				ie.printStackTrace();
			}
		}*/
	}
}

class MyException extends Exception{
	private final int ERR_CODE;
	
	MyException(String msg){
		this(msg, 100);
	}
	
	MyException(String msg, int err_code){
		super(msg);
		ERR_CODE = err_code;
	}	
}