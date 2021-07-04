import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/*
 * @lc app=leetcode id=133 lang=java
 *
 * [133] Clone Graph
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

// class Solution {
//     private HashMap<Node, Node> visited = new HashMap<>();

//     public Node cloneGraph(Node node) {
//         if (node == null) {
//             return node;
//         }
//         // use recursion to build the graph deep copy
//         // so if a node is visited, then we return the copy from hashmap
//         if (visited.containsKey(node)) {
//             return visited.get(node);
//         }

//         // copy the node,
//         // to implement DEEP copy, we should not copy the neighbors,
//         // but creat a new one
//         Node cloneNode = new Node(node.val, new ArrayList());
//         visited.put(node, cloneNode);

//         for (Node neighbor : node.neighbors) {
//             // recursion
//             cloneNode.neighbors.add(cloneGraph(neighbor));
//         }
//         return cloneNode;
//     }
// }

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }

        HashMap<Node, Node> visited = new HashMap<>();

        LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(node);
        Node cloneNode = new Node(node.val, new ArrayList<>());
        visited.put(node, cloneNode);

        while (!queue.isEmpty()) {
            Node u = queue.poll();

            for (Node neighbor : u.neighbors) {
                // if not visited
                if (!visited.containsKey(neighbor)) {
                    queue.add(neighbor);
                    Node cloneNeighbor = new Node(neighbor.val, new ArrayList<>());
                    visited.put(neighbor, cloneNeighbor);
                }
                // visited.get(u) -> get node u's copy node
                // updatae the neighbors list of copy node,
                // build the connection between copy node and its copy neighbors
                visited.get(u).neighbors.add(visited.get(neighbor));
            }
        }

        return cloneNode;
    }
}

// @lc code=end
