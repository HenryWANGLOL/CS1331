public class ArithmeticSequence {

	private int firstterm1;

	private int commondiff1;

	public ArithmeticSequence (int firstterm, int commondiff) {
		firstterm1 = firstterm;

		commondiff1 = commondiff;

	}

	public int getFirstTerm () {

		return firstterm1;
	}

	public int getDifference() {

		return commondiff1;
	}

	public int nth (int n) {
		return firstterm1 + ( n -1 )* commondiff1;
	}

	public int[] subsequence(int n, int m) {

		int[] dog = new int [m-n+1];

		for (int i=0 ; i < m-n+1 ; i++) {

		dog[i] = firstterm1 + (n+i-1) * commondiff1;

	}

	return dog;
}


	public int sumTo (int nth) {
		int sum = firstterm1;
		for (int i=0 ; i<=nth ; i++) {
			sum = sum + nth(i) ;
		}
		return sum;
	}

public static void main (String[] args) {

	int[] x = {1,2,3,4,5};

	for (int i : x) {
		i++;
		System.out.println(i);
	}
	System.out.println(x[0]);
}

	}

