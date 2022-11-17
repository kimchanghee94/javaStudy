package testpackage.javaStudy;

public class MethodTest {
	
}

class Cons {
	protected Cons() {
		
	}
}

class Test implements Runnable{
	public void run() {
		System.out.println("ABC");
	}
}

class Child extends Parent{	
	public void run() {
		System.out.println("DEF");
	}
}

abstract class Parent {
	abstract public void run();
}

class TC{
	TC(Parent p){
		
	}
}