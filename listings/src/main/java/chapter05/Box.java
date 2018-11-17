package chapter05;

public class Box {
  private final int value;

  public Box(int value) { this.value = value; }
  public Box plus(Box other)  { return new Box(this.value + other.value); }
  public Box minus(Box other) { return new Box(this.value - other.value); }
  public int getValue() { return value; }
}

