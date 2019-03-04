package solutions.graphs;

import java.util.*;

/**
 * @author Valentyn.Moliakov
 */
public class Solution16ShortestPath {

    private class Node {
        int value;
        List<Node> children;

        public Node(int value) {
            this.value = value;
        }

        public void addChild(Node n) {
            if (this.children == null) this.children = new LinkedList<Node>();
            this.children.add(n);
        }
    }

    public static List<Node> shortestPath(Node a, Node b) {
        if (a == null || b == null) {
            return null;
        }

        Queue<Node> toVisit = new LinkedList<>();
        Map<Node, Node> parents = new HashMap<>();

        toVisit.add(a);
        parents.put(a, null);

        while (!toVisit.isEmpty()) {
            Node curr = toVisit.remove();
            if (curr == b) break;
            if (curr.children == null) continue;
            for (Node n : curr.children) {
                if (!parents.containsKey(n)) {
                    toVisit.add(n);
                    parents.put(n, curr);
                }
            }
        }

        if (parents.get(b) == null) {
            return null;
        }

        LinkedList<Node> out = new LinkedList<>();
        Node curr = b;

        while (curr != null) {
            out.addFirst(curr);
            curr = parents.get(curr);
        }

        return out;
    }
}
