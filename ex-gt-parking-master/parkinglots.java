public class parkinglots<E> implements Comparable<parkinglots> {
	private E name;
	private E gtID;

	public parkinglots(E name, E gtID) {
		this.name = name;
		this.gtID = gtID;
	}

	public int compareTo(Object o) {
		return this.gtID; 
	}

	public int hashCode() {
		int gtID2 = (int) gtID;
		return gtID2;
	}

	public static void main(String[] args) {
		parkinglots a = new parkinglots("laji",9031);
		System.out.println((a.hashCode));
	}
}