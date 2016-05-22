public class Doo {
	public static double doo(int a, int b, Foo f) {
		return f.bar(a, b);
	}

	public static int addNums(int a, int b) {
		return a + b;
	}

	public static int subtractNums(int a, int b) {
		return a - b;
	}

	public static void main(String...args) {
		System.out.println(doo(2, 3, Doo::subtractNums));
	}
}