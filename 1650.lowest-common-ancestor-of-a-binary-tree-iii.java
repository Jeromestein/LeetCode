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
        // the length of p (len1) and the length of q (len2)
        // we make ptr1=p and then q, ptr2=q and then p
        // because len1+len2=len2+len1
        // so in the worst case, T-O(len1+len2), S-O(1)

        Node ptr1 = p, ptr2 = q;
        while (ptr1 != ptr2) {
            ptr1 = (ptr1 == null) ? q : ptr1.parent;
            ptr2 = (ptr2 == null) ? p : ptr2.parent;
        }
        return ptr1;

    }
}
// @lc code=end
