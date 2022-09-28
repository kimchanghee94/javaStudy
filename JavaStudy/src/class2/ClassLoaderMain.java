package class2;

public class ClassLoaderMain {
	public static void main(String[] args) {
		/*Run Configuration에 jvm 옵션설정 잘못한 부분 수정 완료*/
		System.out.println("main is start");
		
		AClass ac = new AClass();
		BClass bc = new BClass();
		
		ac.Amethod();
		bc.Bmethod();
	}
}
