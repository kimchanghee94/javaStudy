package testpackage.javaStudy3;

import java.util.Comparator;
import java.util.TreeSet;

public class Collect {
	public static void main(String[] args) {
		//Comparator ±¸Çö
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