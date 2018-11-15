package chapter05.exercise5_2;

import static chapter05.exercise5_2.TreasureChest.Status.OPEN;
import static chapter05.exercise5_2.TreasureChest.Status.SEALED;

/**
 * @author Peter Sommerhoff <peter@petersommerhoff.com>
 */
class TreasureChest {

    // You don't have to use an enum here but it's good practice to avoid Kotlin keywords as field or method names.
    enum Status { OPEN, SEALED }

    private Status status = SEALED;

    // Here, `object` was a hard keyword so it's definitely better to avoid it
    Object treasure = new Diamond();

    // Here we avoid the hard keyword `is`; `contains` is a more conventional for this anyway
    boolean contains(Object object) { return this.treasure == object; }

    // `open` is a modifier in Kotlin but it's a good method name and unlikely to cause confusion so we kept it here.
    void open() { this.status = OPEN; }
    void seal() { this.status = SEALED; }

    // This avoids the soft keyword `get` as there's no need for it, it's a bad method name anyway
    Status status() { return this.status; }

    class Diamond {}
}
