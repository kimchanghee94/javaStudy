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
	}
}