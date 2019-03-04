package solutions.recursion;

import java.util.Stack;

/**
 * @author Valentyn.Moliakov
 */
public class Solution18LowestCommonAncestor {

    public class Node {
        int value;
        Node left, right;
    }

    public static Node lca(Node tree, Node n1, Node n2) {
        if (n1.equals(n2)) return n1;
        Stack<Node> pathToN1 = pathToNode(tree, n1);
        Stack<Node> pathToN2 = pathToNode(tree, n2);

        Node prev = null;
        while (!pathToN1.isEmpty() && !pathToN2.isEmpty()) {
            Node n1Ancestor = pathToN1.pop();
            Node n2Ancestor = pathToN2.pop();
            if (n1Ancestor.equals(n2Ancestor)) prev = n1Ancestor;
            else break;

        }
        return prev;
    }

    private static Stack<Node> pathToNode(Node tree, Node n) {
        if (tree == null) return null;
        if (tree.equals(n)) {
            Stack<Node> s = new Stack<>();
            s.push(n);
            return s;
        }

        Stack<Node> left = pathToNode(tree.left, n);
        Stack<Node> right = pathToNode(tree.right, n);

        if (left != null) {
            left.push(tree);
            return left;
        }

        if (right != null) {
            right.push(tree);
            return right;
        }

        return null;
    }

}
