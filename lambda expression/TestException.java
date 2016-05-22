public class TestException {
	public static void main (String[] args) {
		int n = 6;
		try {
			ExceptionMethod.printNumber(n);
		} catch (CannotBeSevenException e) {
			System.out.println(e.getMessage());
		}
	}
}