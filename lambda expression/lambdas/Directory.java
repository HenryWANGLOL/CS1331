import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
public class Directory {
	public static void main(String[] args) {
		List<Student> students = new ArrayList<Student>();
		students.add(new Student("Ralph", 9033));
		students.add(new Student("Alphie", 9929));
		students.add(new Student("Alphie", 8933));
		students.add(new Student("Jay", 2333));
		//Collections.sort(students, new Comparator<Student>() {
		//	public int compare(Student s1, Student s2) {
		//		return s1.getName().compareTo(s2.getName());
		//	}
		//});
		//Collections.sort(students, (s1, s2) -> (s1.getName().compareTo(s2.getName())));
		Collections.sort(students, Comparator.comparing(Student :: getName).thenComparing(Student :: getGtid));
		for(Student s: students) {
			System.out.println(s.getName() + " " +  s.getGtid());
		}
	}
}
