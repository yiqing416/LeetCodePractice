package graph;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class CloneGraph {
    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node (int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node (int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    private HashMap<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        //deep clone the graph

        if (node == null) {
            return null;
        }

        if (map.containsKey(node)) {
            return node;
        }

        Node cloned_node = new Node(node.val);
        map.put(node, cloned_node);

        for (Node neighbor : node.neighbors) {
            Node cloned_neighbor = cloneGraph(neighbor);
            cloned_node.neighbors.add(cloned_neighbor);
        }

        return cloned_node;

    }

}
