package class2;

public class ClassLoaderMain {
	public static void main(String[] args) {
		/*Run Configuration에 jvm 옵션설정 잘못한 부분 수정 완료*/
		/* class loader를 누가 호출하는지 알 수없을까... 일단 넘기고 jvm정의 파악 진행해야되나... */
		/* 이클립스의 클래스패스는 이클립스 워크스페이스의 bin파일로 설정되어있다.
		 *  대신 jre를 가져와야 하기 때문에 프로젝트안에 jre도 존재해야한다.
		 *  CMD로 돌릴 경우에는 JAVA_HOME에 있는 lib파일을 가져와 돌린다.
		 *  */
		System.out.println("main is start");

		System.out.println("========================================>");
		platform.Test.TestExtClass tec = new platform.Test.TestExtClass();
		java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
		System.out.println(date.getClass().getClassLoader());
		tec.method();
		System.out.println(tec.getClass().getClassLoader());
		System.out.println("<========================================");
		
		System.out.println("========================================>");
		ClassLoader cl = ClassLoaderMain.class.getClassLoader();
		System.out.println("main print " + cl.getClass());
		System.out.println("main print " + cl.getParent());
		System.out.println("main print " + cl.getParent().getParent());
		System.out.println("main print " + cl.getParent().getParent().getParent());
		System.out.println("<========================================");
		
		System.out.println("========================================>");
		System.out.println(System.getProperty("java.class.path"));
		System.out.println(ClassLoader.getPlatformClassLoader());
		System.out.println("<========================================");
		
		
		System.out.println("========================================>");
		AClass ac = new AClass();
		BClass bc = new BClass();
		
		ac.Amethod();
		bc.Bmethod();
		System.out.println("<========================================");
	}
}
