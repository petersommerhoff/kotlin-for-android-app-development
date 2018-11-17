package chapter04;

class UnsafeArrays {
  public static void main(String[] args) {
    Number[] arr = new Integer[3];  // Arrays are covariant
    arr[0] = 3.7;                   // Causes ArrayStoreException
  }
}
