package class1;

public class printHello {
	public static void main(String[] args) {
		System.out.println("print Hello World");
		
		AbstTest at = new AbstTest() {
			
		};
		at.testMethod();
	}
}

abstract class AbstTest{
	public void testMethod() {
		System.out.println("abstTest");
	}
}