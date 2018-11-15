@file:JvmName("JvmAnnotations")

package chapter05.exercise5_3

/**
 * @author Peter Sommerhoff <peter@petersommerhoff.com>
 */

/*
 * 1) You want to prevent the generation of getters and setters for a property and instead allow direct field access.
 * -> @JvmField exposes a property directly as a field in the Java bytecode, thus without getters or setters.
 */
class ExposedField {
  @JvmField val exposed = "No getter or setter"
}

/*
 * 2) You want to prevent class names such as CandyKt or CookieKt when using your Kotlin files from Java.
 * -> Any renaming of identifiers when compiling to Java bytecode can be done via @JvmName. To rename the class
 * generated from an entire file as in this scenario is done using @file:JvmName at the top of the file.
 */
// See top of this file for an example

/*
 * 3) You want to be able to call a companion object method directly on its containing class from Java.
 * -> Calling a method directly on a Java class is enabled by static methods so you need the @JvmStatic annotation.
 */
class Accessor {
  companion object {
    @JvmStatic fun access() {}
  }
}

/*
 * 4) You want to at least have some of the overloaded options to call a Kotlin function with optional arguments from Java.
 * -> This is enabled by adding @JvmOverloads to the function declaration. It only enabled a constrained form of
 * optional arguments because the order of parameters is preserved -- for n optional parameters, only n+1 different
 * combinations of calling the method from Java are enabled.
 */
@JvmOverloads fun overloaded(i: Int = 1, s: String = "", d: Double = 0.0) {}