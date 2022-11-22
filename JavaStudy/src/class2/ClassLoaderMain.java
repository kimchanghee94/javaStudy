package class2;

public class ClassLoaderMain {
	public static void main(String[] args) {
		/*MEMO*/
		/* class loader를 누가 호출하는지 알 수없을까... 일단 넘기고 jvm정의 파악 진행해야되나... */
		/* 이클립스의 클래스패스는 이클립스 워크스페이스의 bin파일로 설정되어있다.
		 *  module path의 경우 시스템 라이브러리로 설정되는데 해당 모듈은 jdk를 설치한 경로로 설정된다.
		 *  class path의 경우에는 Referenced Libraries에 넣은 경로나
		 *  개발자가 이클립스로 실행을 할 때 개발한 class파일의 경로 등이 포함된다.
		 *  
		 *  커스텀 클래스 로드의 경우 우선 개발자가 개발한 클래스파일들에 대해서만 로드가 되는데
		 *  내가 만일 상위 클래스를 직접 구현함으로 상위 클래스에서 호출할 필요가 없는 경우
		 *  커스텀 클래스 로드에서는 따로 부모 클래스를 찾아갈 필요가 없기 때문이다.
		 *  
		 *  메인클래스를 실행할 때 메인클래스에서 필요로 하는 클래스만 먼저 상위클래스에서 로드를 한다.
		 *  (Object클래스는 필수가 되버린다.)
		 *  로드타임 동적로딩과 런타임동적로딩이 있는데 Object와 같이 클래스가 실행되기 전에
		 *  필요한 클래스들을 읽어들여 클래스로더에서 로드하는 것을 로드타임 동적로딩이라면,
		 *  
		 *   런타임 동적로딩은 아래에 Date, TestExtClass와 같이 실행 도중에 필요로하여 클래스를 로드하는 것을
		 *   런타임 동적로딩이라 한다.
		 *  */

		System.out.println("main is start");
		System.out.println("========================================>");
		//platform.Test.TestExtClass tec = new platform.Test.TestExtClass();
		java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
		System.out.println(date.getClass().getClassLoader());
		//tec.method();
		//System.out.println(tec.getClass().getClassLoader());
		System.out.println("<========================================\n");
		
		System.out.println("========================================>");
		Boolean boolFlag = true;
		System.out.println(boolFlag.getClass().getClassLoader());
		System.out.println("<========================================\n");
		
		System.out.println("========================================>");
		ClassLoader cl = ClassLoaderMain.class.getClassLoader();
		System.out.println("main print " + cl.getClass());
		System.out.println("main print " + cl.getParent());
		System.out.println("main print " + cl.getParent().getParent());
		System.out.println("main print " + cl.getParent().getParent().getParent());
		System.out.println("<========================================\n");
		
		System.out.println("========================================>");
		System.out.println(System.getProperty("java.class.path"));
		//jdk 1.9부터 사용 가능
		//System.out.println(ClassLoader.getPlatformClassLoader());
		System.out.println("<========================================\n");
		
		
		System.out.println("========================================>");
		AClass ac = new AClass();
		BClass bc = new BClass();
		
		ac.Amethod();
		bc.Bmethod();
		System.out.println(ac.getClass().getClassLoader());
		System.out.println(ac.getClass().getClassLoader().getParent());
		System.out.println("<========================================\n");
	}
}
