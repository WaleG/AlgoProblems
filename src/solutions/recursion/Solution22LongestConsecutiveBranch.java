package solutions.recursion;

/**
 * @author Valentyn.Moliakov
 */
public class Solution22LongestConsecutiveBranch {

    private class Node {
        int value;
        Node left, right;
    }

    public static int consecutive(Node node) {
        if (node == null) return 0;
        return Math.max(consecutive(node.left, node.value, 1), consecutive(node.right, node.value, 1));
    }

    private static int consecutive(Node node, int prev, int length) {
        if (node == null) return length;
        if (node.value == prev + 1) {
            int leftLength = consecutive(node.left, node.value, length + 1);
            int rightLength = consecutive(node.right, node.value, length + 1);
            return Math.max(leftLength, rightLength);
        } else {
            int leftLength = consecutive(node.left, node.value, 1);
            int rightLength = consecutive(node.right, node.value, 1);
            return Math.max(Math.max(leftLength, rightLength), length);
        }
    }
}
