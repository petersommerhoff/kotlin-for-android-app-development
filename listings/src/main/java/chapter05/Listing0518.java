package chapter05;

public class Listing0518 {
  public static void main(String[] args) {
    Cache0518.cache("supercar", new Car());      // Static member is callable directly on class
    Cache0518.INSTANCE.cache("car", new Car());  // Bad practice

    Car0518.produceCar();                        // Static
    Car0518.Factory.produceCar();                // Also possible
    (new Car0518()).produceCar();                // Bad practice

  }
}
