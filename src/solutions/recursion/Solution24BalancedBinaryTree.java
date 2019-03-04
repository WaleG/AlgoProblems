package solutions.recursion;

/**
 * @author Valentyn.Moliakov
 */
public class Solution24BalancedBinaryTree {

    private class Node {
        int value;
        Node left;
        Node right;
    }

    public boolean isBalanced(Node node) {
        if(balancedHeight(node) > -1) return true;
        return false;
    }

    private int balancedHeight(Node node) {
        if (node == null) return 0;
        int hLeft = balancedHeight(node.left);
        int hRight = balancedHeight(node.right);
        if (hLeft == -1 || hRight == -1) return -1;
        if (Math.abs(hLeft - hRight) > 1) return -1;
        if (hLeft > hRight) return hLeft + 1;
        return hRight + 1;
    }
}
