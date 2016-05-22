import java.util.Comparator;
import java.util.Map.Entry;
import java.util.Map;
/**
* the Merge Sort Method Comparator to sort the voter's votes
* @author Yufeng Wang
* @version 1.0
*/
public class MapComparator implements
    Comparator<Map.Entry<String, Integer>> {
    /**
   * the compare method
   * @param o1 object 1 to be compared
   * @param o2 object 2 to be compared
   * @return the integer telling the order of two object
   */
    @Override
    public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
        int s = (int) o1.getValue();
        int n = (int) o2.getValue();
        if (s > n) {
            return 1;
        } else if (s == n) {
            return o2.getKey().compareTo(o1.getKey()); //sort alphabatically
        } else {
            return -1;
        }
    }
}