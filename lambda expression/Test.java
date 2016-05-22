import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;

public class Test {
	/*
	private int aVariable;

	public static void main(String[] args) {
		int age = 6;

	}

	public int swag() {
		People s = new People();
		s.getAge();	
		return 4;	
	}

	private class People {
		public int age;

		public int getAge() {
			return 4;
		} 
	}

	*/

	/*
	Inner Class Example
	private class PersonAgeComparator implements Comparator<Person> {
		public int compare(Person a, Person b) {
			return a.getAge().compareTo(b.getAge());
		}
	}

	public static void main(String[] args) {
		ArrayList<Person> allThePeople = new ArrayList<Person>();
		Person[] peopleArray = allThePeople.toArray(new Person[roster.size]);
		Arrays.sort(peopleArray, new PersonAgeComparator());
	}
	*/

/*
	//Anonymous Class Example

	public static void main(String[] args) {

		ArrayList<Person> allThePeople = new ArrayList<Person>();

		Person[] peopleArray = allThePeople.toArray(new Person[allThePeople.size()]);

		Arrays.sort(peopleArray, new Comparator<Person>() {

			public int compare(Person a, Person b) {
				return a.getAge() - b.getAge();
			}

		});
	}

	*/
/*
	//Lambda Expressions

	public static void main(String[] args) {

		ArrayList<Person> allThePeople = new ArrayList<Person>();

		Person[] peopleArray = allThePeople.toArray(new Person[allThePeople.size()]);

		Arrays.sort(peopleArray, (a, b) -> { 
				return a.getAge() - b.getAge();
			}
		);
	}
*/


/*
	//Lamba Expressions WITH Method References
	public static void main(String[] args) {

		ArrayList<Person> allThePeople = new ArrayList<Person>();

		Person[] peopleArray = allThePeople.toArray(new Person[allThePeople.size()]);

		Arrays.sort(peopleArray, Person::compareByAge);
	}
*/


	//Lamba Expressions WITH Method References TESTING STUDENT CODE
	public static void main(String[] args) {

		ArrayList<Person> allThePeople = new ArrayList<Person>();

		Person[] peopleArray = allThePeople.toArray(new Person[allThePeople.size()]);

		Person a = new Person("23", 23);
		Arrays.sort(peopleArray, new Person("23", 23)::compareByAge);
	}



}




/*

class ComparisonProvider {
    public int compareByName(Person a, Person b) {
        return a.getName().compareTo(b.getName());
    }
        
    public int compareByAge(Person a, Person b) {
        return a.getBirthday().compareTo(b.getBirthday());
    }
}
ComparisonProvider myComparisonProvider = new ComparisonProvider();
Arrays.sort(rosterAsArray, myComparisonProvider::compareByName);
*/



/*
Format of Anonymous Class

Type referenceName = new Type() {
	//class implementation
}

Swing GUI, Android
Eventlisteners and Listeners 

http://developer.android.com/reference/android/widget/Button.html

*/

