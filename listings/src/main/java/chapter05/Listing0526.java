package chapter05;

import java.io.FileNotFoundException;

public class Listing0526 {
  public static void main(String[] args) {
    try {  // Must handle exception
      CsvUtils.readInput();  // Assumes @file:JvmName("CsvUtils")
    } catch (FileNotFoundException e) {
      // Handle non-existing file...
    }
  }
}
