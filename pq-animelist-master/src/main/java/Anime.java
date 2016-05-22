import java.util.Comparator;
import java.util.Collections;
// TODO: Implement an appropriate interface to impose an ordering on Anime
public class Anime implements Comparator<Anime>{
    private String name;
    private int yearOfProduction;

    public Anime(String name, int yearOfProduction) {
        this.name = name;
        this.yearOfProduction = yearOfProduction;
    }

    public String getName() {
        return name;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public int compare(Anime a, Anime b) {
        return a.getName().compareTo(b.getName());
    } 


    public String toString() {
        return name + " : " + yearOfProduction;
    }

    /*
     * TODO: YOUR CODE BELOW
     * Fill out the return type and method body
     * This method should compare animes based on their name.
     **/
}