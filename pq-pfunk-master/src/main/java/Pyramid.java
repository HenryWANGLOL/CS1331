public class Pyramid extends Pfunker {

	public Pyramid(String name) {
        super(name);
    }
	

	
    public String accomplishTask(String task) {
        return getName()
            + " will " + task + " by delegating to grade student";
    }
}