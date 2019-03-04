package solutions.recursion;

/**
 * @author Valentyn.Moliakov
 */
public class Solution25BinarySearchTreeValidation {

    private class Node {
        int value;
        Node left;
        Node right;
    }

    public boolean isValid(Node n) {
        return isValid(n, null, null);
    }

    private boolean isValid(Node n, Integer min, Integer max) {
        if (n == null) return true;
        if (min != null && n.value <= min) return false;
        if (max != null && n.value >= max) return false;
        return isValid(n.left, min, n.value) && isValid(n.right, n.value, max);
    }
}
