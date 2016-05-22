/**
* Moive.java has the important information of the movies
* @author  Yufeng Wang
* @version 1.0
*/
import java.util.Set;
public class Movie implements Comparable<Movie> {

    private String name;
    private double rating;
    private int year;
    private Set<Genre> genres;

    /**
    * The constructor of movie
    * @param name
    * @param rating
    * @param year
    * @param genres
    */
    public Movie(String name, double rating, int year, Set<Genre> genres) {
        this.name = name;
        this.rating = rating;
        this.year = year;
        this.genres = genres;
    }

    /**
    * @return genres of the moive
    */
    public Set<Genre> getGenres() {
        return genres;
    }

    /**
    * @return name of the movie
    */
    public String getName() {
        return name;
    }

    /**
    * @return rating of the movie
    */
    public double getRating() {
        return rating;
    }

    /**
    * @return year of the movie
    */
    public int getYear() {
        return year;
    }

    /**
    * natural compare order by name
    * @param other the other Movie
    * @return int with alphabetical order
    */
    public int compareTo(Movie other) {
        return this.name.compareTo(other.name);
    }

    /**
    * override the equal method
    * @param other comparing object
    * @return true two sets are equal
    */
    @Override
    public boolean equals(Object other) {
        if (null == other) {
            return false;
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof Movie)) {
            return false;
        }
        Movie that = (Movie) other;
        return this.name.equals(that.name);
    }

    /**
    * override hashCode method
    * @return result the hashcode integer
    */
    public int hashCode() {
        int result = 17;
        result = 31 * result + name.hashCode();
        return result;
    }

    /**
    * override the toString
    * @return the contents of Movie Set
    */
    public String toString() {
        String str = new String();
        for (Genre agenre : genres) {
            str = str + agenre + " ";
        }
        return name + " (" + year + ") - " + rating + " { " + str + "}";
    }


}