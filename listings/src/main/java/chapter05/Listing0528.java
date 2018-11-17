package chapter05;

public class Listing0528 {
  public static void main(String[] args) {
    Listing0528Kt.consumeStack(new Stack<Number>(4, 8, 15, 16, 23, 42));
    Listing0528Kt.consumeStack(new Stack<Integer>(4, 8, 15, 16, 23, 42));
  }
}
