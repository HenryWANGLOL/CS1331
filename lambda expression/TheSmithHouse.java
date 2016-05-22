import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.function.BiPredicate;
import java.util.Comparator;
import java.util.function.Supplier;

public class TheSmithHouse {

    public static void main(String[] args) {

        ArrayList<Person> peeps = new ArrayList<>();
        peeps.add(new Person("Jerry", 35, 1));
        Person rick = new Person("Rick", 80, 99);
        peeps.add(rick);
        peeps.add(new Person("Morty", 12, 10));
        peeps.add(new Person("Beth", 33, 15));
        peeps.add(new Person("Summer", 16, 33));

        printArrayList(peeps);

        //Method reference for our demo
        demo(rick::speak);
        //Lambda for our demo
        demo(() -> "Wubalubbadubdub!");

        // Method reference for our lambda
        Collections.sort(peeps, Person::compareByAge);

        //Lambdas
        Collections.sort(peeps, (Person a, Person b) -> {
            return b.getAge() - a.getAge();
        });
//        Collections.sort(peeps, (Person a, Person b) -> {
//            return b.getName().compareTo(a.getName());
//        });

        //Example method that would take in an anonymous inner class
        //using the functional interface Predicate
        // This would work if we had a method header of sort like this:
        // public void sort(List<T> l, Predicate<T> p)
//        sort(peeps, new Predicate<Person>() {
//            //method definitions
//
//        });


        // Anonymous Inner Class
//        Collections.sort(peeps, new Comparator<Person>() {
//            public int compare(Person a, Person b) {
//                return b.getAge() - a.getAge();
//            }
//
//        });
//        Collections.sort(peeps, new SortByAgeComparator()); 

        printArrayList(peeps);

    }

    // Example method of our own that requires a functional interface
    public static void demo(Supplier<String> supp) {
        System.out.println(supp.get());
    }

    public static void printArrayList(ArrayList<Person> list) {
        System.out.println("----");
        for (Person a : list) {
            System.out.println(a);
        }
    }

}







