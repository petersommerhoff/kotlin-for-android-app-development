package chapter05;

import java.util.Arrays;
import java.util.List;

public class Listing0506 {
  public static List<String> myListOf(String... strings) {  // Vararg method from Java
    return Arrays.asList(strings);                          // Can pass in vararg unchanged
  }
}
