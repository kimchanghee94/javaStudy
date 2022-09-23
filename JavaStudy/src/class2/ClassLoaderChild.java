package class2;

public class ClassLoaderChild extends ClassLoader{
	ClassLoaderChild(){
		super();
		System.out.println("ClassLoader is open");
	}
	
	public static void main(String[] args) {
		System.out.println("main is here");
	}
}
