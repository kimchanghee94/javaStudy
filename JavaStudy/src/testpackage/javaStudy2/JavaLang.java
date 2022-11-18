package testpackage.javaStudy2;

public class JavaLang {
	public static void main(String[] args) {
		Point p1 = new Point(4,5);
		Point p2 = null;
		try {
			p2 = p1.clone();			
		} catch(CloneNotSupportedException cne) {
			cne.printStackTrace();
		}
		
		p2.x = 2;
		System.out.println(p1);
		System.out.println(p2);
		
		Circle c1 = new Circle(new Point(2,3), 4);
		Circle c2 = null;
		try {
			c2 = c1.cloneCircle();
		} catch (CloneNotSupportedException cne) {
			cne.printStackTrace();
		}
		
		c2.p.x = 3;
		c2.r = 1;
		System.out.println(c1);
		System.out.println(c2);
		
		char[] arr = new char[4];
		arr[0] = '1';
		String str = new String(arr);
		System.out.println(str + "," + str.length());
	}
}

class Point implements Cloneable{
	int x, y;
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
	
	//공변 반환 타입 => 오버라이딩할 때 반환 타입을 자손 객체 타입으로 선언할 수 있다.
	public Point clone() throws CloneNotSupportedException {
		Point obj = null;
		
		obj = (Point)super.clone();
		return obj;
	}
}

class Circle implements Cloneable{
	Point p;
	int r;
	
	Circle(Point p, int r){
		this.p = p;
		this.r = r;
	}
	
	public String toString() {
		return this.p + " r=" + r;
	}
	
	public Circle cloneCircle() throws CloneNotSupportedException {
		Circle obj = null;
		obj = (Circle)super.clone();
		//깊은 복사
		obj.p = obj.p.clone();
				//new Point(obj.p.x, obj.p.y);
		return obj;
	}
}