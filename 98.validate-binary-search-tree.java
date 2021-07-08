/*
 * @lc app=leetcode id=98 lang=java
 *
 * [98] Validate Binary Search Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        // -2^31 <= Node.val <= 2^31 - 1
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode node, long lowerBound, long upperBound) {
        if (node == null) {
            return true;
        }
        // The left subtree of a node contains only nodes with keys < the node's key.
        // The right subtree of a node contains only nodes with keys > the node's key.
        if (node.val <= lowerBound || node.val >= upperBound) {
            return false;
        }
        return isValidBST(node.left, lowerBound, node.val) && isValidBST(node.right, node.val, upperBound);
    }
}
// @lc code=end
