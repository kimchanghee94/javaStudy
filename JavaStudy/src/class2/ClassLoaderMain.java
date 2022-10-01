package class2;

public class ClassLoaderMain {
	public static void main(String[] args) {
		/*Run Configuration에 jvm 옵션설정 잘못한 부분 수정 완료*/
		/* class loader를 누가 호출하는지 알 수없을까... 일단 넘기고 jvm정의 파악 진행해야되나... */
		System.out.println("main is start");
		
		AClass ac = new AClass();
		BClass bc = new BClass();
		
		ac.Amethod();
		bc.Bmethod();
	}
}
