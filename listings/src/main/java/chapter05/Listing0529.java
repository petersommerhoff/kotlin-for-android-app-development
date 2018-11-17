package chapter05;

public class Listing0529 {
  public static void main(String[] args) {
    Listing0529Kt.consumeStack0529(new Stack<Number>(4, 8, 15, 16, 23, 42));   // Matches exactly
    Listing0528Kt.consumeStack(new Stack<Integer>(4, 8, 15, 16, 23, 42));  // Error: No longer allowed

//    Stack<Number> stack = Listing0529Kt.produceStack0529();            // Error: No longer allowed
    Stack<? extends Number> stack = Listing0529Kt.produceStack0529();  // Inconvenient, thus bad practice
  }
}
