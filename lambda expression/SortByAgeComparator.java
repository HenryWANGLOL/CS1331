import java.util.Comparator;
public class SortByAgeComparator implements Comparator<Person> {

    public int compare(Person a, Person b) {
        return b.getAge() - a.getAge();
    }

}
