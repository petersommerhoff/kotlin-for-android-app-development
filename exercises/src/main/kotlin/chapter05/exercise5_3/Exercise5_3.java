package chapter05.exercise5_3;

/**
 * @author Peter Sommerhoff <peter@petersommerhoff.com>
 */
public class Exercise5_3 {

    public static void main(String[] args) {

        String field = new ExposedField().exposed;

        Accessor.access();

        JvmAnnotations.overloaded();
        JvmAnnotations.overloaded(42);
        JvmAnnotations.overloaded(42, "Hello");
        JvmAnnotations.overloaded(42, "Hello", 3.14159);
    }
}
