public class Clone extends Pfunker{


    public Clone(String name) {
        super(name);
    }

    
    public String accomplishTask(String task) {
        return getName()
            + " will "
            + task + " by working on it between ultimate frisbee games.";
    }
}
