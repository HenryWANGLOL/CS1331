public class Person {


    private String name;
    private int age;
    private int intelligence;

    public Person(String name, int age, int intelligence) {
        this.name = name;
        this.intelligence = intelligence;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return name;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getAge() {
        return age;
    }

    public static int compareByAge(Person a, Person b) {
        return b.getAge() - a.getAge();
    }

    public String speak() {
        return "Wubalubbadubdub!";
    }

//    public void sort(ArrayList<Person> peeps, Predicate<T> functionalInterface) {
//
//    }
}
