package chapter05.exercise5_2;

/**
 * @author Peter Sommerhoff <peter@petersommerhoff.com>
 */
class TreasureChestOriginal {
    public static final String sealed = "SEALED";
    public static final String open = "OPEN";
    String status = sealed;
    Object object = new Diamond();

    boolean is(Object object) { return this.object == object; }
    void open() { this.status = open; }
    void seal() { this.status = sealed; }
    String get() { return this.status; }

    class Diamond {}
}
