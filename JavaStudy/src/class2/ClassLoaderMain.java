package class2;

public class ClassLoaderMain {
	public static void main(String[] args) {
		/*Run Configuration�� jvm �ɼǼ��� �߸��� �κ� ���� �Ϸ�*/
		/* class loader�� ���� ȣ���ϴ��� �� ��������... �ϴ� �ѱ�� jvm���� �ľ� �����ؾߵǳ�... */
		/* ��Ŭ������ Ŭ�����н��� ��Ŭ���� ��ũ�����̽��� bin���Ϸ� �����Ǿ��ִ�.
		 *  ��� jre�� �����;� �ϱ� ������ ������Ʈ�ȿ� jre�� �����ؾ��Ѵ�.
		 *  CMD�� ���� ��쿡�� JAVA_HOME�� �ִ� lib������ ������ ������.
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
