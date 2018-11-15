package chapter05.exercise5_1;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.List;
import java.util.Map;

/**
 * @author Peter Sommerhoff <peter@petersommerhoff.com>
 */
public class Exercise5_1 {

    public static double calculateAverage() { return 1.0; }  // Only method that cannot return null

    public static Integer getAge() { return null; }

    public static @NonNull
    List<String> titles() { return null; }  // Can still return null, but with a warning

    public static char[] toCharArray() { return null; }

    public static Person[] getAttendees() { return null; }

    public static Object get() { return null; }

    public static <T> List<? extends Comparable<T>> fetchRatings() { return null; }

    public static Map<@NonNull Address, @NonNull List<Employee>> locationsToEmployees() { return null; }

    public class Address {}
    public class Employee {}
    public class Person {}
}
