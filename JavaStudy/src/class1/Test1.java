package class1;

public class Test1 {
	public static void main(String[] args) {
		Tt t = new Tt();
		t.add(3, 4);
	}
}

class Tt implements f1, f2 {
	public void add(int a, int b) {
		System.out.println(a + ":" + b);
	}
}

interface f1 {
	public default void add(int a, int b) {
	};
}

interface f2 {
	public default void add(int a, int b) {
		System.out.println(a + b);
	};
}