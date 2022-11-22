package class2;

public class ClassLoaderMain {
	public static void main(String[] args) {
		/*MEMO*/
		/* class loader�� ���� ȣ���ϴ��� �� ��������... �ϴ� �ѱ�� jvm���� �ľ� �����ؾߵǳ�... */
		/* ��Ŭ������ Ŭ�����н��� ��Ŭ���� ��ũ�����̽��� bin���Ϸ� �����Ǿ��ִ�.
		 *  module path�� ��� �ý��� ���̺귯���� �����Ǵµ� �ش� ����� jdk�� ��ġ�� ��η� �����ȴ�.
		 *  class path�� ��쿡�� Referenced Libraries�� ���� ��γ�
		 *  �����ڰ� ��Ŭ������ ������ �� �� ������ class������ ��� ���� ���Եȴ�.
		 *  
		 *  Ŀ���� Ŭ���� �ε��� ��� �켱 �����ڰ� ������ Ŭ�������ϵ鿡 ���ؼ��� �ε尡 �Ǵµ�
		 *  ���� ���� ���� Ŭ������ ���� ���������� ���� Ŭ�������� ȣ���� �ʿ䰡 ���� ���
		 *  Ŀ���� Ŭ���� �ε忡���� ���� �θ� Ŭ������ ã�ư� �ʿ䰡 ���� �����̴�.
		 *  
		 *  ����Ŭ������ ������ �� ����Ŭ�������� �ʿ�� �ϴ� Ŭ������ ���� ����Ŭ�������� �ε带 �Ѵ�.
		 *  (ObjectŬ������ �ʼ��� �ǹ�����.)
		 *  �ε�Ÿ�� �����ε��� ��Ÿ�ӵ����ε��� �ִµ� Object�� ���� Ŭ������ ����Ǳ� ����
		 *  �ʿ��� Ŭ�������� �о�鿩 Ŭ�����δ����� �ε��ϴ� ���� �ε�Ÿ�� �����ε��̶��,
		 *  
		 *   ��Ÿ�� �����ε��� �Ʒ��� Date, TestExtClass�� ���� ���� ���߿� �ʿ���Ͽ� Ŭ������ �ε��ϴ� ����
		 *   ��Ÿ�� �����ε��̶� �Ѵ�.
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
		//jdk 1.9���� ��� ����
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
