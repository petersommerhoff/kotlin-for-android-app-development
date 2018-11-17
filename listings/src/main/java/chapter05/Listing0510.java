package chapter05;

public class Listing0510 {
  public static void main(String[] args) {
    KotlinClass kotlinClass = new KotlinClass();
    String s = kotlinClass.getFixed();     // Uses getter of ‘val’
    kotlinClass.setMutable(true);          // Uses setter of ‘var’
    boolean b = kotlinClass.getMutable();  // Uses getter of ‘var’
  }
}
