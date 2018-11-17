package chapter05;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Listing0504 {
  public static @Nullable String nullable() { return null; }
  public static @NotNull String nonNull() { return "Could still be null, but with a warning"; }
}
