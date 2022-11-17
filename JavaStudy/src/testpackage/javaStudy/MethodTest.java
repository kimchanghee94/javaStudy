package testpackage.javaStudy;

public class MethodTest {
	CC c = new CCChild();
}

interface CC{
	
}

class Cons implements CC{
	protected Cons() {
		
	}
}

class CCChild extends Cons{
	
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