import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
/**
* the class contains the important information of the library
*
* @author  Yufeng Wang
* @version 1.0
*/
public class Library {

    private List<Movie> library;

    /**
    * library constructor
    * @param library List of Movies
    */
    public Library(List<Movie> library) {
        this.library = library;
    }

    public List<Movie> getList() {
        return library;
    }

    /**
    * list all comedy movie alphabetically
    * @return sorted list
    */
    public List<Movie> listAlphabetically(Genre a) {
        ArrayList<Movie> library2 = new ArrayList<Movie>();
        library2.addAll(library);
        library2 = moviesWithGenre(library2, a);
        Collections.sort(library2);
        return library2;
    }


    /**
    * sort by year range
    * @return sorted list
    */
    public List<Movie> listByYearRange(int start, int end) {
        ArrayList<Movie> library2 = new ArrayList<Movie>();
        for (Movie aMovie : library) {
            if (aMovie.getYear() >= start && aMovie.getYear() < end) {
                library2.add(aMovie);
            }
        }
        Collections.sort(library2, (Movie m1, Movie m2) -> {
                if (m1.getYear() > m2.getYear()) {
                    return -1;
                } else if (m1.getYear() < m2.getYear()) {
                    return 1;
                } else {
                    return m1.getName().compareTo(m2.getName());
                }
            });

        return library2;
    }

    /**
    * sort from lowest to highest rating
    * @return sorted list
    */
    public List<Movie> listByLowestRating() {
        List<Movie> library2 = new ArrayList<Movie>();
        library2.addAll(library);
        Collections.sort(library2, (Movie m1, Movie m2) -> {
                if (m1.getRating() > m2.getRating()) {
                    return 1;
                } else if (m1.getRating() < m2.getRating()) {
                    return -1;
                } else {
                    return m1.getName().compareTo(m2.getName());
                }
            });
        return library2;
    }

    /**
    * sort from lowest to highest rating
    * @return sorted list
    */
    public List<Movie> listByHighestRating() {
        List<Movie> library2 = new ArrayList<Movie>();
        library2.addAll(library);
        Collections.sort(library, new RatingComparator());
        return library2;
    }

    /**
    * sort movies with specified genres
    * @param movies     the movies list that needs to be sorted
    * @param g          the genre that need to be select
    * @return movies contains g genre
    */
    public ArrayList<Movie> moviesWithGenre(List<Movie> movies, Genre g) {
        ArrayList<Movie> targets = new ArrayList<Movie>();
        for (Movie aMovie : movies) {
            if (aMovie.getGenres().contains(g)) {
                targets.add(aMovie);
            }
        }
        return targets;
    }

    /**
    * reverse the sorting
    * @param m  the movie list to reverse
    * @return sorted list
    */
    public ArrayList<Movie> reverseCall(List<Movie> m) {
        ArrayList<Movie> reversed = new ArrayList<Movie>();
        for (int i = m.size() - 1; i >= 0; i--) {
            Movie obj = m.get(i);
            reversed.add(obj);
        }
        return reversed;
    }

    private static class RatingComparator implements Comparator<Movie> {

        /**
        * sort all action or adventure genre movie with rating
        * @param moive1  first comparator
        * @param movie2 second comparactor
        * @return int for comparison
        */
        public int compare(Movie moive1, Movie movie2) {
            if (moive1.getRating() > movie2.getRating()) {
                return -1;
            } else if (moive1.getRating() < movie2.getRating()) {
                return 1;
            } else {
                return moive1.getName().compareTo(movie2.getName());
            }
        }
    }


}