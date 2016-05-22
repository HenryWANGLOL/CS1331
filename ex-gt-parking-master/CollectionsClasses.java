import java.util.*;

public class CollectionsClasses {
    public static void main(String[] args) {
        List<Integer> myList = new ArrayList<>();
        myList.add(new Integer(1));
        myList.add(6);
        for (Integer n : myList) {
            System.out.println(n);
        }
        Set<String> names = new TreeSet<>();
        names.add("Gustavo");
        for(String name : names) {
            System.out.println(name);
        }
        System.out.println(names.contains("Gustavo"));
    }
}
