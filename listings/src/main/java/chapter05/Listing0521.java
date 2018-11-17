package chapter05;

import static java.lang.System.out;

public class Listing0521 {
  public static void main(String[] args) {
    Person p1 = new Person("Peter", true);
    Person p2 = new Person("Marie Curie", false);
    Person p3 = p2.copy("Marie Curie", false);  // No advantage over constructor

    String name = p1.getName();  // componentN() methods superfluous
    out.println(p1);             // Calls toString()
    out.println(p2.equals(p3));  // true
  }
}
