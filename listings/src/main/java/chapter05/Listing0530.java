package chapter05;

public class Listing0530 {
  public static void main(String[] args) {
    Nothing.takeNothing(null);  // Possible in Java (but with warning due to @NonNull)
    Nothing.fail("Cannot pass null to non-null variable");    // Cannot terminate
    System.out.println("Never reached but Java doesn't know");  // Dead code
  }
}
