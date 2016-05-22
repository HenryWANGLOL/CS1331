public class LambdaLab {
	public static String change(String s, StringModificator m) {
		return m.modify(s);
	}


	public static void main(String[] args) {
		String s = "Hello world!";
		// String newString = change(s, String::toUpperCase);
		// String newString = change(s, (x) -> x.toUpperCase());
		String newString = change(s, new StringModificator() {
			public String modify(String x) {
				return x.toUpperCase();
			}
		});
		System.out.println(newString);
	}
}