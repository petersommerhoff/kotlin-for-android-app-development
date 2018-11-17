open class Cache private constructor() {
  val INSTANCE = Cache()

  protected var size: Long = 4096  // Getter inherits visibility from property
    private set                    // Setter can have a different visibility
}
