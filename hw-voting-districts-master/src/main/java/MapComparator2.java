import java.util.Comparator;
import java.util.Map.Entry;
import java.util.Map;
/**
* the Merge Sort Method Comparator to sort the local district
* @author Yufeng Wang
* @version 1.0
*/
public class MapComparator2 implements
    Comparator<Map.Entry<String, String>> {
    /**
    * the compare method
    * @param o1 object 1 to be compared
    * @param o2 object 2 to be compared
    * @return the integer telling the order of two object
    */
    @Override
    public int compare(Entry<String, String> o1, Entry<String, String> o2) {
        String s = o1.getValue();
        String n = o2.getValue();
        return s.compareTo(n); //sort alphabatically
    }
}