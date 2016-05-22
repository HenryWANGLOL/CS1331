import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class StudentDirectory {
	public static void main(String[] args) {
		Student s1 = new Student("Keagan", 343);
		Student s2 = new Student("Jay", 242);
		Student s3 = new Student("Blake", 532);
		Student s4 = new Student("Alphie", 532); 

		List<Student> students = new ArrayList<Student>();
		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
		//Collections.sort(students, new NameComparator());
		/*Collections.sort(students, new Comparator<Student>() {
			public int compare(Student s1, Student s2) {
				return s1.getName().compareTo(s2.getName());
			}
		});
		//lambdas
		Collections.sort(students, (st1, st2) -> {
			int result = st1.getName().compareTo(st2.getName());
			if (result == 0) {
				return st1.getGtid() - st2.getGtid();
			} else if(st1.isSuspended()) {
				return -1;
			} else {
				return result;
			}
		});*/
		Collections.sort(students, 
			Comparator.comparing(Student::getGtid));
		//Collections.sort(students);//sort by gtid
		for(Student s: students) {
			System.out.println(s.getName() + s.getGtid());
		}
	}
	private class NameComparator implements Comparator<Student> {
		public int compare(Student s1, Student s2) {
			return s1.getName().compareTo(s2.getName());
		}
	}
}