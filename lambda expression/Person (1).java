public class Person {
	private String name;
	private int age;


	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
/*
	public static int compareByAge(Person a, Person b) {
		return a.getAge() - b.getAge();
	}
*/

	public int compareByAge(Person a, Person b) {
		return a.getAge() - b.getAge();
	}

	public static int compareByAge(Person a, Person b, Person c) {
		return a.getAge() - b.getAge() - c.getAge();
	}

}