package class2;

public class ClassLoaderMain {
	public static void main(String[] args) {
		/*Run Configuration�� jvm �ɼǼ��� �߸��� �κ� ���� �Ϸ�*/
		System.out.println("main is start");
		
		AClass ac = new AClass();
		BClass bc = new BClass();
		
		ac.Amethod();
		bc.Bmethod();
	}
}
