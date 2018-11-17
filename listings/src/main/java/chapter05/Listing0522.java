package chapter05;

import kotlin.jvm.JvmClassMappingKt;
import kotlin.reflect.KClass;

public class Listing0522 {
  public static void main(String[] args) {
    KClass<A> clazz = JvmClassMappingKt.getKotlinClass(A.class);
  }

  class A {}
}
