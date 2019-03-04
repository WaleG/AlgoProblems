package solutions.recursion;

/**
 * @author Valentyn.Moliakov
 */
public class Solution23PrintReversedLinkedList {

    private class Node {
        int value;
        Node next;
    }

    public static void printReversed(Node node) {
        if (node == null) return;
        printReversed(node.next);
        System.out.println(node.value);
    }
}
