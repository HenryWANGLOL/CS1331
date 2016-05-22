public class ExceptionMethod{
	
	public static void printNumber(int n) throws CannotBeSevenException {
		if (n == 7) {
			throw new CannotBeSevenException("your number cannot be seven");
		}
		System.out.println("shabi");
	}
}