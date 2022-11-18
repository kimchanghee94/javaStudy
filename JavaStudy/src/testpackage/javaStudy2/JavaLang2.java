package testpackage.javaStudy2;

import java.util.Objects;

public class JavaLang2 {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer(20);
		StringBuffer sb2 = new StringBuffer(16);
		String str = new String("Test");
		
		sb.append(str);
		sb2.append(str);
		
		System.out.println(sb);
		System.out.println(sb.length());
		
		String cur = sb.toString();
		String tmp = sb2.toString();
		
		System.out.println(cur.equals(tmp));
		
		System.out.println(Objects.isNull(cur));
	}
}
