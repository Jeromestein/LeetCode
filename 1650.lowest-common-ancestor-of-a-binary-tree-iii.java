/*
 * @lc app=leetcode id=1650 lang=java
 *
 * [1650] Lowest Common Ancestor of a Binary Tree III
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        // 1. find parents of p, store as a list
        // 2. find parents of q, find the LCA
        // T-O(h), S-O(h)

        Node a = p, b = q;
        while (a != b) {
            a = a == null ? q : a.parent;
            b = b == null ? p : b.parent;
        }
        return a;

    }
}
// @lc code=end
