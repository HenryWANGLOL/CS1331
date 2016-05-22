import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.Collections;

/**
 * Your Netflix journey begins here!
 *
 * @author Jayanth
 * @author Srijan
 * @author Yufeng Wang
 * @version 1.0
 */
public class Netflix {

    private static Scanner in;
    private static PopulateNetflix popPop;
    private static Random rand;
    private static Library library;
    private static List<Movie> list;

    /**
     * Main method for Netflix. This produces the high-end login screen
     * for our Netflix service that took a team of experienced
     * UI designers to create.
     *
     * @param args command-line arguments for the program.
     */
    public static void main(String[] args) throws Exception {
        in = new Scanner(System.in);
        popPop = new PopulateNetflix();
        library = new Library(popPop.getNetflixPopulation());
        list = library.getList();
        // map from roommate names to a list of movies. See the instructions
        // for which roommates to add and what their watchlists should be
        Map userWatchLists = new HashMap();
        List<Movie> library2 = new ArrayList<Movie>();
        List<Movie> library3 = new ArrayList<Movie>();
        List<Movie> library4 = new ArrayList<Movie>();
        library2 = library.listAlphabetically(Genre.COMEDY);

        library3.addAll(list); // add all the elements
        ArrayList<Movie> choice1 = library.moviesWithGenre(library3,
            Genre.ACTION);
        ArrayList<Movie> choice2 = library.moviesWithGenre(library3,
            Genre.ADVENTURE);
        choice1.addAll(choice2); //include all action and adventure moive
        library3.retainAll(choice1); //filter out the other type of moives
        Collections.sort(library3, Comparator.comparing(Movie :: getRating));
        library4 = library.listByYearRange(1980, 2000);
        userWatchLists.put("Taylor", library2);
        userWatchLists.put("George",  library3);
        userWatchLists.put("Sarah",  library4);

        boolean running = true;
        System.out.println("Welcome to your very own Netflix service!");
        while (running) {
            System.out.println("\nNow, who's watching tonight? [q to exit]");

            String response = in.nextLine();
            if (response.equals("q")) {
                System.out.println("Thanks for watching!");
                running = false;
            } else if (userWatchLists.containsKey(response)) {
                List<Movie> watchList =
                    (List<Movie>) userWatchLists.get(response);

                int numMovies = -1;
                while (numMovies < 1) {
                    System.out.println("How many movies would you like"
                        + " to watch? (1 - 10)");
                    try {
                        numMovies = Integer.parseInt(in.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input, please try again");
                    }
                }

                System.out.println("\nHere you go!\n");

                if (numMovies > watchList.size()) {
                    numMovies = watchList.size();
                }
                for (Movie m : watchList.subList(0, numMovies)) {
                    System.out.println(m);
                }
            } else {
                System.out.println("\nNetflix does not "
                    + "recognize that input\n");
            }
        }
    }
}
