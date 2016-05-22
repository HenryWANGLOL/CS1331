public class Lollypop extends Pfunker {


    public Lollypop(String name) {
        super(name);
    }

    @Override
    public String accomplishTask(String task) {
        return getName()
            + " will " + task + " by pulling two all-nighters in a row.";
    }
}
