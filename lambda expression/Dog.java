/*
Comparable
- interface
- compareTo(T b)
- "natural ordering"
- Dog - compare by age
  ascending order
  */
import java.util.*;

/*
For recitation about lambda expressions and why
they're used. About touched on Comparable vs.
Comparator.

This code will compile as work as it is. However,
some methods are deliberately left incomplete
for this version. No such thing as a free lunch. ;)
*/
public class Dog implements Comparable<Dog> {
  private int age;
  private int numLegs;
  public Dog(int age, int numLegs) {
    this.age = age;
    this.numLegs = numLegs;
  }
  public int getAge() {
    return age;
  }
  public int getNumLegs() {
    return numLegs;
  }
  public String toString() {
    return "Age: " + age + "\nNum of legs: " + numLegs;
  }

  // for "natural ordering"
  public int compareTo(Dog b) {
    // a.compareTo(b);
    // i want to compare by age
    // Fido - age 4, Spot - age 7
    // Fido (a) < Spot (b) -> negative number
    // Spot (a) > Fido (b) -> positive number
    // Fido = Fido -> zero
    return this.getAge() - b.getAge();
  }

  // for method reference
  public static int compareByNumLegs(Dog a, Dog b) {
      return 0;
      // [What do I put here?]
  }

  public static void main(String[] args) {
    ArrayList<Dog> dogs = new ArrayList<>();
    dogs.add(new Dog(1, 4));
    dogs.add(new Dog(2, 4));
    dogs.add(new Dog(8, 3));
    dogs.add(new Dog(5, 15));
    dogs.add(new Dog(3, 2));
    dogs.add(new Dog(100, 2));
    dogs.add(new Dog(50, 5));
    dogs.add(new Dog(-1, 40));
    dogs.add(new Dog(15, 1));
    for (Dog d : dogs) {
      System.out.println(d);
    }

    System.out.println("-----");
    // natural order
    Collections.sort(dogs);

    // inner class
    Comparator<Dog> dLC = new DogLegComparator();
    Collections.sort(dogs, dLC);

    // anonymous inner class
    /*
    Collections.sort(dogs, new Comparator<Dog>() {
      [what do i put in here?]
      Hint: see private inner class
      Hint 2: it's the functional interface's only abstract method
    });
    */

    // lambda expression
    /*
    Collections.sort(dogs,
      ([what do I put in here?])  // Hint: compare(T a, T b)
      ->
      {
        [what do i put in here?]
        // Hint: return type of compare is int
      }
    );
    */

    // method reference
    /*
    Collections.sort(dogs, [what do I put in here?]);
    Hint: see the method compareByNumLegs
    */

    // fun uses of method references
    // something that you can use if you know
    /*
    System.out.println("awesome sort");
    Comparator<Dog> awesomeSort =
        Comparator.comparing(Dog::getNumLegs)
        .thenComparing(Dog::getAge);
    Collections.sort(dogs, awesomeSort);
    */

    for (Dog d : dogs) {
      System.out.println(d);
    }

    System.out.println("----------");
    // method references with strings!
    ArrayList<String> randStuff = new ArrayList<>();
    randStuff.add("durian");
    randStuff.add("apple");
    randStuff.add("pommegranate");
    randStuff.add("Mango");
    randStuff.add("persimmon");
    for (String s : randStuff) {
      System.out.println(s);
    }
    System.out.println("-----");
    // vs. compareToIgnoreCase - something new in Java 8!
    Collections.sort(randStuff, String::compareTo);
    for (String s : randStuff) {
      System.out.println(s);
    }
  }

  // private inner class
  private static class DogLegComparator implements Comparator<Dog> {
    public int compare(Dog a, Dog b) {
      return 0;
      // [What do I put here?]
    }
  }
}

