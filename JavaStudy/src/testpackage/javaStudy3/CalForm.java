package testpackage.javaStudy3;

import java.text.MessageFormat;
import java.util.Comparator;
import java.util.TreeSet;

public class CalForm {
	public static void main(String[] args) {
		//pattern 형태의 경우 '문자를 쓰면 escape와 같기 때문에 ''두번 써줘야한다.
		String str = "''{0}'' {1}";
		Object[] argu = {"abc", "def"};
		
		String result = MessageFormat.format(str, argu);
		System.out.println(result);
		
		
		//Comparator 구현
		TreeSet ts = new TreeSet(new CompTest());
		ts.add(7); ts.add(5); ts.add(6);
		System.out.println(ts);
	}
}

class CompTest implements Comparator{
	public int compare(Object o1, Object o2) {
		if(o1 instanceof Comparable && o2 instanceof Comparable) {
			Comparable c1 = (Comparable)o1;
			Comparable c2 = (Comparable)o2;
			return c2.compareTo(c1);
		}
		return 1;
	}
}
