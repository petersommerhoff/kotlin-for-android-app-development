package chapter05;

import static java.lang.System.out;
import static java.util.Arrays.asList;

public class Listing0520 {
  public static void main(String[] args) {
    Component comp = new Composite(asList(new Leaf(1), new Leaf(17)));

    if (comp instanceof Composite) {    // Cannot use ‘switch’, must use ‘if’
      out.println("It's a Composite");  // No smart-casts
    } else if (comp instanceof Leaf) {  // No exhaustiveness inferred
      out.println("It's a Leaf");
    }
  }
}
