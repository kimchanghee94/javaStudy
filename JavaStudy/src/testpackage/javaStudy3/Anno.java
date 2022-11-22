package testpackage.javaStudy3;

import java.util.Arrays;

class MyArrayList<T>{
	T[] arr;
	
	@SafeVarargs
	@SuppressWarnings("varargs")
	MyArrayList(T... arr){
		this.arr = arr;
	}
	
	//unchecked만 사용해도 main메서드에서는 경고가 발생하지 않는다....
	//오히려 unchecked하나로 통일해서 사용하는게 더 깔끔하다...
	@SuppressWarnings("unchecked")
	public static <T> MyArrayList<T> asList(T... arr) {
		return new MyArrayList<>(arr);
	}
	
	@Override
	public String toString() {
		return Arrays.toString(arr);
	}
}

public class Anno {
	public static void main(String[] args) {
		MyArrayList<String> list = MyArrayList.asList("1","2","3");
		System.out.println(list);
	}
}
