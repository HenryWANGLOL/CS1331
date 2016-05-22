import java.util.ArrayList;
import java.util.Iterator;
import java.util.Comparator;
import java.util.Collections;

public class MyAnimeList implements Iterable<Anime> {
    private ArrayList<Anime> animeList;
    private int numofelemets;

    public MyAnimeList() {
        animeList = new ArrayList<Anime>();
    }

    public void add(Anime a) {
        animeList.add(a);
        numofelemets++;
    }

    public String toString() {
        return animeList.toString();
    }

    /*
     * TODO: YOUR CODE BELOW
     * Fill out the method body. It should only have one line.
     **/
    public void sortByName() {
        Collections.sort(animeList, 
            Comparator.comparing(Anime::getName));
    }

    /*
     * TODO: YOUR CODE BELOW
     * Fill out the method body. It should only have at most two line.
     **/
    public void sortByYear() {
        Collections.sort(animeList, 
            Comparator.comparing(Anime::getYearOfProduction));
    }

    /*
     * TODO: YOUR CODE BELOW
     * change method body to return new AnimeIterator() after
     * implementing AnimeIterator.
     **/
    public Iterator<Anime> iterator() {
        return new AnimeIterator();
    }

    private class AnimeIterator implements Iterator<Anime> {
        
        private int cursor = 0;

        public boolean hasNext() {
            return numofelemets > cursor;
            
        }

        public Anime next() {
            
            return  animeList.get(cursor++);
        }

        public void remove() {
            animeList.remove(--cursor);
        }
    }
}