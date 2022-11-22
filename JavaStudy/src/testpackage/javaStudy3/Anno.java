package testpackage.javaStudy3;

import java.util.Arrays;

class MyArrayList<T>{
	T[] arr;
	
	@SafeVarargs
	@SuppressWarnings("varargs")
	MyArrayList(T... arr){
		this.arr = arr;
	}
	
	//unchecked�� ����ص� main�޼��忡���� ��� �߻����� �ʴ´�....
	//������ unchecked�ϳ��� �����ؼ� ����ϴ°� �� ����ϴ�...
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
