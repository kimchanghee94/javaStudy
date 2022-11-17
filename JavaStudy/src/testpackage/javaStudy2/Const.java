package testpackage.javaStudy2;

import testpackage.javaStudy.*;

public class Const {
	public static void main (String[] args) {
		MethodTest cmt = new ChildMethodTest();
	}
}

class ChildMethodTest extends MethodTest{
	static int a = 3;
	
	static void method() {
		
		System.out.println(a);
	}
}