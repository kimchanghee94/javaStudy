package testpackage.javaStudy3;

import java.util.ArrayList;

public class Generic {
	public static void main(String[] args) {
		//Box<Toy> toyBox = new Box<>();
		Box<Fruit> fruitBox = new Box<>();
		Box<Apple> appleBox = new Box<>();
		fruitBox.add(new Apple());
		
		//�� ���·� �����ϸ� FruitŸ�Ժ����� ���Եȴ�.
		Box b = new Box();
		
		//���׸� Ÿ�԰� �����׸�Ÿ�԰��� ����ȯ
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

//FruitŬ������ �����ϴ� Ŭ�����鸸 ����� �� �ֵ���
class Box<T extends Fruit & Eatable> {
	ArrayList<T> al = new ArrayList<>();
	void add(T item) {	al.add(item);}	
	T get(int idx) {return al.get(idx);}	
	int size() {return al.size();}	
	public String toString() {return al.toString();}
}
 
enum Direction {
	EAST(50), WEST(40), SOUTH(20), NORTH(100);
	
	//value���� ����� ����ؼ� final�� �ٿ��ִ°� �Ϲ���
	private final int value;
	//enum�� �����ڴ� private�� �ڵ����� ������ �ٴ´�.
	//������ �Ű����� ���� ������ �� ������� ���ڰ��� ������ ��ġ�ؾ��Ѵ�.
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