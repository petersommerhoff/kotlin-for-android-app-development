package chapter05.exercise5_6;

import java.util.Arrays;
import java.util.List;

/**
 * @author Peter Sommerhoff <peter@petersommerhoff.com>
 */
public class CallingClass {

    static void useTrees() {
        List<Tree<Integer>> leafs = Arrays.asList(
            new Leaf<>(2),
            new Leaf<>(3)
        );
        Tree<Integer> tree = new Branch<>(1, leafs);

        // "Original" method
        // Note that the IDE cannot infer the generic type in the argument until the second one is passed in
        TreesOriginalKt.applyToAllNodes(node -> node * node, tree);

        // Improved `map` method
        TreeUtils.map(tree, integer -> integer * integer);

        System.out.println(tree);  // Uses Branch.toString() from data class
    }

    public static void main(String[] args) {
        useTrees();
    }
}
