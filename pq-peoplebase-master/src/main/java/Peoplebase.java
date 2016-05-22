public class Peoplebase {

	private Person[] personarray; 

	public Peoplebase (Person...ren) {
		personarray = ren ;
	}
	public Person finaByName(String name) {
		for (Person p : personarray ) {
			if (p.getName().equals(name)) {
				return p;
			}
		}
		return null;

		}


	public Person findByHomeTown(String homeTown){
		for (Person h : personarray) {
			if (h.getHomeTown().equals(homeTown)){
				return  h;
			}
		}

		return null;


	}

}