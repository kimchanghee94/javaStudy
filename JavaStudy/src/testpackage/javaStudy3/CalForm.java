package testpackage.javaStudy3;

import java.text.MessageFormat;
import java.util.Comparator;
import java.util.TreeSet;

public class CalForm {
	public static void main(String[] args) {
		//pattern ������ ��� '���ڸ� ���� escape�� ���� ������ ''�ι� ������Ѵ�.
		String str = "''{0}'' {1}";
		Object[] argu = {"abc", "def"};
		
		String result = MessageFormat.format(str, argu);
		System.out.println(result);		
	}
}