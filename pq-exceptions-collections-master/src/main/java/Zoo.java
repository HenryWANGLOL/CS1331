import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Zoo {
    private List<Animal> animals;
    private HashSet<Animal> animals2;
    private int count;

    public Zoo() {
        this.animals = new ArrayList<Animal>(10);
    }

    public void add(Animal a) {
        animals.add(a);
        animals2.add(a);
    }

    public List<Animal> getList() {
        return animals;
    }

    public HashSet<Animal> getTypes() {
        return  animals2;
    }


    public Map<Animal, Integer> getAnimalCounts(Animal[] zooSection) {
        return null;

    }
}
