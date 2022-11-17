package testpackage.javaStudy;

import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStudy {
	public static void main(String[] args) {
		Student[] stuArr = new Student[] {
				new Student("KCH", 1, 380),
				new Student("LHY", 1, 370),
				new Student("JMW", 2, 250),
				new Student("SJO", 2, 255),
				new Student("YJW", 3, 320),
				new Student("WTT", 3, 310)
		};
		
		Stream<Student> stuStream1 = Stream.of(stuArr);
		Stream<Student> stuStream2 = Stream.of(stuArr);
		Stream<Student> stuStream3 = Stream.of(stuArr);
		Stream<Student> stuStream4 = Stream.of(stuArr);
//		OptionalInt totalScore = stuStream.mapToInt(Student::getTotalScore).reduce((a,b)->a+b);
//		int totalScoreColl = stuCollStream.collect(Collectors.summingInt(Student::getTotalScore));
//		System.out.println(totalScore.getAsInt());
//		System.out.println(totalScoreColl);
		
//		OptionalInt topScore1 = stuStream1.mapToInt(Student::getTotalScore).max();
//		Optional<Student> topScore2 = stuStream2
//				.max(Comparator.comparingInt(Student::getTotalScore));
//		
//		Optional<Student> topScore3 = stuStream3
//				.collect(Collectors.maxBy(Comparator.naturalOrder()));
//		
//		System.out.println(topScore1.getAsInt());
//		System.out.println(topScore2.get().getTotalScore());
//		System.out.println(topScore3.get().getTotalScore());
//		OptionalInt topScore1 = stuStream1.mapToInt(Student::getTotalScore).max();
//		Optional<Integer> topScore2 = 
//				stuStream2.map(Student::getTotalScore)
//				.max(Integer::compareTo);
		/*인자값으로 들어오는 값은 Intger고 Integer 래퍼클래스 안에는 compare와 compareTo가 구현되어있다 */
//		System.out.println(topScore2);
		
		IntSummaryStatistics stat1 = stuStream1.mapToInt(Student::getTotalScore).summaryStatistics();
		IntSummaryStatistics stat2 = stuStream2
				.collect(Collectors.summarizingInt(Student::getTotalScore));
		
		System.out.println(stat1.getMax());
		System.out.println(stat2.getAverage());
	}
}

class Student implements Comparable<Student> {
	int ban, totalScore;
	String name;

	Student(String name, int ban, int totalScore) {
		this.ban = ban;
		this.totalScore = totalScore;
		this.name = name;
	}

	int getBan() {
		return this.ban;
	}

	int getTotalScore() {
		return this.totalScore;
	}

	String getName() {
		return this.getName();
	}

	public int compareTo(Student s) {
		return s.totalScore - this.totalScore;
	}
}