/*
 * @lc app=leetcode id=426 lang=java
 *
 * [426] Convert Binary Search Tree to Sorted Doubly Linked List
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    // the smallest (first) and the largest (last) nodes
    Node first = null, last = null;

    public void inOrder(Node node) {
        if (node == null) {
            return;
        } else {
            // use in-order travesal walk through all the nodes
            // left
            inOrder(node.left);
            // node
            if (last != null) {
                // link the previous node (last)
                // with the current one (node)
                last.right = node;
                node.left = last;
            } else {
                // keep the smallest node
                // to close DLL later on
                first = node;
            }
            // make current node as the last node
            last = node;
            // right
            inOrder(node.right);
        }
    }

    public Node treeToDoublyList(Node root) {
        if (root == null)
            return null;

        inOrder(root);
        // close DLL
        last.right = first;
        first.left = last;
        return first;
    }
}

// @lc code=end
