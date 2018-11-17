package chapter05;

public class Listing0519 {
  public static void main(String[] args) {
    String[] languages = new String[] {"Kotlin", "Scala", "Java", "Groovy"};

    // Without @JvmOverloads: you must pass in all parameters
    ArrayUtils.join(languages, ";", "{", "}");    // Assumes @file:JvmName("ArrayUtils")

    // With @JvmOverloads: overloaded methods
    ArrayUtils.join(languages);                                 // Skips all optional parameters
    ArrayUtils.join(languages, "; ");                   // Skips prefix and suffix
    ArrayUtils.join(languages, "; ", "Array: ");  // Skips suffix
    ArrayUtils.join(languages, "; ", "[", "]");   // Passes in all possible arguments
  }
}
