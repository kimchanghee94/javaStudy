package class2;

public class JVMTest {
	public static void main(String[] args) {
		/* �ش� Ŭ������ �����Ͽ��� �� System.getProperty�� Ŭ���� �⺻ ��ΰ� ����ִ��� �� ���ִ�.
		 * �� ��° ������δ� cmd�� echo %CLASSPATH%�� �Է��ϴ� ����̰� 
		 * CLASSPATH��ο� .;�� �ִٸ� ���� ��ο��� Ŭ�����н��� ã�ڴٴ� �ǹ��̴�.
		 * ������ �ַܼ� �ش� Ŭ���� ��ο��� javac�� �����ϸ� class1�̶�� ��Ű�� ���ο� Ŭ���������� ������ ���̴�.
		 * �׷��� �ڿ������� ���� class2���� ���ο��� �ٷ� java JVMTest�� �غ����� ������ �ȵ� ���̴�.
		 * Ŭ�����н��� ��Ű�� ��α����� �����Ѱɱ�...
		 * ���� ����δ� JVMTest.class������ �ִ� ��ġ�Ƿ� -cp�ɼ��� �־� class2������ �ִ� ��ĭ �������͸��� �̵��ؾ��Ѵ�.
		 * ���� java -cp .. class2.JVMTest�� �����ؾ��Ѵ�. 
		 * */
		System.out.println(System.getProperty("java.class.path"));
		System.out.println("This is JVMTEST Main Code");
	}
}
