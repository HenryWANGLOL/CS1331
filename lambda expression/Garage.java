import java.util.Arrays;
import java.util.Comparator;
public class Garage {
	private Car[] cars;
// //inner class
// 	public class CarComparator implements Comparator<Car> {
// 		public int compare(Car c1, Car c2){ 
// 		return c1.getMake().compareTo(c2.getMake());// getmake is from Car.java
// 		}
// 	}

	public void CarSort() {
		Arrays.sort(cars, new CarComparator<Car>() {
			public int compare(Car c1, Car c2) {
				return c1.getMake().compareTo(c2.getMake);
			}
		});
		// sort by make
	}

	public void CarSort2() {
		Arrays.sort(cars, (Car c1, Car c2) -> c1.getMake().compareTo(c2.getMake()));
	}

	public void CarSort3() {
		Arrays.sort(cars, (Car c1, Car c2) -> {
			int i = c1.getYear() + c2.getYear();
			return c1.getMake().compareTo(c2.getMake())
		});
	}
}