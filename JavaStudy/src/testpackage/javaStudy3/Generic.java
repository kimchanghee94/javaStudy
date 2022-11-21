package testpackage.javaStudy3;

import java.util.ArrayList;

public class Generic {
	public static void main(String[] args) {
		//Box<Toy> toyBox = new Box<>();
		Box<Fruit> fruitBox = new Box<>();
		Box<Apple> appleBox = new Box<>();
		fruitBox.add(new Apple());
		
		//이 상태로 선언하면 Fruit타입변수가 대입된다.
		Box b = new Box();
		
		//지네릭 타입과 논지네릭타입간의 형변환
		Box b2 = null;
		Box<Fruit> fBox = null;
		//b2 = (Box)fBox;
		fBox = (Box<Fruit>)b2;
		
		EnumTest et = new EnumTest();
		et.move(Direction.EAST);
	}
}

interface Eatable{}
class  Fruit implements Eatable{public String toString() {return "FRUIT";}}
class Apple extends Fruit{public String toString() {return "Apple";}}
class Graph extends Fruit{public String toString() {return "Graph";}}
class Toy{public String toString() {return "Toy";}}

//Fruit클래스를 참조하는 클래스들만 사용할 수 있도록
class Box<T extends Fruit & Eatable> {
	ArrayList<T> al = new ArrayList<>();
	void add(T item) {	al.add(item);}	
	T get(int idx) {return al.get(idx);}	
	int size() {return al.size();}	
	public String toString() {return al.toString();}
}
 
enum Direction {
	EAST(50), WEST(40), SOUTH(20), NORTH(100);
	
	//value값은 상수로 취급해서 final을 붙여주는게 일반적
	private final int value;
	//enum의 생성자는 private가 자동으로 무조건 붙는다.
	//생성자 매개변수 선언 순서는 위 상수안의 인자값의 순서와 일치해야한다.
	private Direction(int value) {
		this.value = value;
	}
	public int getValue() {
		return this.value;
	}
	public String toString() {
		return name() + ", " + getValue(); 
	}
}
class EnumTest{
	public void move(Direction dir) {
		switch(dir) {
		case EAST: System.out.println(dir);
			break;
		}
	}
}