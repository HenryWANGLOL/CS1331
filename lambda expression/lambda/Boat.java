import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Boat {
	String name;
	int size;

	public Boat(String name, int size) {
		this.name = name;
		this.size = size;
	}

	public String toString() {
		return "Boat " + name + ": " + size;
	}

	public static int compareByName(Boat a, Boat b) {
		return a.name.compareTo(b.name);
	}

	public static void main(String[] args) {
		ArrayList<Boat> aB = new ArrayList<>();
		aB.add(new Boat("Titanic", 2));
		aB.add(new Boat("SS Anne", 2));
		aB.add(new Boat("SS Aqua", 1));
		// Collections.sort(aB, Boat::compareByName);
		// Collections.sort(aB, (x, y) -> compareByName(x, y));
		Collections.sort(aB, new Comparator<Boat>() {
			public int compare(Boat a, Boat b) {
				return a.name.compareTo(b.name);
			}
		});
		System.out.println(aB);
		Collections.sort(aB, (a, b) -> {
			return a.name.compareTo(b.name);
		});
		System.out.println(aB);
	}
}