package class2;

public class JVMTest {
	public static void main(String[] args) {
		/* 해당 클래스를 빌드하였을 때 System.getProperty로 클래스 기본 경로가 어디있는지 알 수있다.
		 * 두 번째 방법으로는 cmd로 echo %CLASSPATH%를 입력하는 방법이고 
		 * CLASSPATH경로에 .;이 있다면 현재 경로에서 클래스패스를 찾겠다는 의미이다.
		 * 문제는 콘솔로 해당 클래스 경로에서 javac로 빌드하면 class1이라는 패키지 내부에 클래스파일이 떨어질 것이다.
		 * 그러면 자연스럽게 현재 class2폴더 내부에서 바로 java JVMTest를 해보지만 실행이 안될 것이다.
		 * 클래스패스는 패키지 경로까지만 가능한걸까...
		 * 현재 내경로는 JVMTest.class파일이 있는 위치므로 -cp옵션을 주어 class2폴더가 있는 한칸 상위디렉터리로 이동해야한다.
		 * 따라서 java -cp .. class2.JVMTest로 실행해야한다. 
		 * */
		System.out.println(System.getProperty("java.class.path"));
		System.out.println("This is JVMTEST Main Code");
	}
}
