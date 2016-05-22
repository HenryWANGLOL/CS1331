public class Student implements Comparable<Student> {
	private int gtid;
	private String name;
	private boolean isSuspended;
	public Student(String name, int id) {
		gtid = id;
		this.name = name;
		this.isSuspended = false;
	}
	public int getGtid() {
		return gtid;
	}
	public String getName() {
		return name;
	}
	public boolean isSuspended() {
		return isSuspended;
	}
	public int compareTo(Student other) {
		return getGtid() - other.getGtid();
		//natural ordering
	}
	@Override
	public int hashCode() {
		int result = 17;
		int b = isSuspended ? 1 : 0;
		result = result * 31 + b;
		int g = (int)gtid;
		result = result * 31 + g;
		int n = name.hashCode();
		result = result * 31 + n;
        	return result;
		//Set<Genres> set;
		//for(Movie m: set) {
		//	m.ordinal()
		//}
	}
	
}
