public class Person {

	private String firstparameter;

	private String secondparameter;

	public Person (String firstparameter, String secondparameter){

		this.firstparameter = firstparameter;

		this.secondparameter = secondparameter;

	}

	public String toString() {
		return firstparameter + "from" + secondparameter;

	}

	public String getName() {

		return firstparameter;
	}

	public String getHomeTown () {

		return secondparameter;
	}

}