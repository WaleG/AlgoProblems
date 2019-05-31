package other;

import java.util.*;

/**
 * @author Valentyn.Moliakov
 */
public class Dijkstra {
    /*
    Algorithm:
    1) Set distance to startNode to zero;
    2) Set all other distances to infinite value;
    3) We add the startNode to unsettled nodes set;
    4) While the unsettled nodes set is not empty we:
        a) Choose an evaluation node from the unsettled nodes set,
        the evaluation node should be the one with the lowest distance from the source
        b) Calculate new distances to direct neighbors by keeping the lowest distance at each evaluation
        c) Add neighbors that are not yet settled to the unsettled nodes set;
     */

    public static Graph calculateShortestPathFromSource(Graph graph, Node source) {
        source.distance = 0;

        Set<Node> settledNodes = new HashSet<>();
        Set<Node> unsettledNodes = new HashSet<>();

        unsettledNodes.add(source);

        while (unsettledNodes.size() != 0) {
            Node currentNode = unsettledNodes
                    .stream()
                    .min(Comparator.comparingInt(node -> node.distance))
                    .get();
            unsettledNodes.remove(currentNode);
            for (Map.Entry<Node, Integer> adjacencyPair: currentNode.adjacentNodes.entrySet()) {
                Node adjacentNode = adjacencyPair.getKey();
                Integer edgeWieght = adjacencyPair.getValue();
                if (!settledNodes.contains(adjacentNode)) {
                    calculateMinimumDistance(adjacentNode, edgeWieght, currentNode);
                    unsettledNodes.add(adjacentNode);
                }
            }
            settledNodes.add(currentNode);
        }

        return graph;
    }

    private static void calculateMinimumDistance(Node evaluationNode, Integer edgeWeight, Node sourceNode) {
        if (sourceNode.distance + edgeWeight < evaluationNode.distance) {
            evaluationNode.distance = sourceNode.distance + edgeWeight;
            evaluationNode.shortestPath = new LinkedList<>(sourceNode.shortestPath);
            evaluationNode.shortestPath.add(sourceNode);
        }
    }

    public class Graph {
        Set<Node> nodes = new HashSet<>();

        public void addNode(Node node) {
            nodes.add(node);
        }
    }

    public class Node {
        String name;
        List<Node> shortestPath = new LinkedList<>();
        Integer distance = Integer.MAX_VALUE;
        Map<Node, Integer> adjacentNodes = new HashMap<>();

        public void addDestination(Node destination, int distance) {
            adjacentNodes.put(destination, distance);
        }

        public Node(String name) {
            this.name = name;
        }
    }
}
