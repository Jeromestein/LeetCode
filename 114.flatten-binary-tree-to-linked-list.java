/*
 * @lc app=leetcode id=114 lang=java
 *
 * [114] Flatten Binary Tree to Linked List
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public void flatten(TreeNode root) {
        TreeNode node = root, rightmost = null;
        while (node != null) {
            if (node.left != null) {
                // find the rightmost in node's left subtree
                rightmost = node.left;
                while (rightmost.right != null) {
                    rightmost = rightmost.right;
                }

                // let this rightmost's right point to node's right subtree
                rightmost.right = node.right;

                // let node's right point to its left tree
                // let node's left point to null
                node.right = node.left;
                node.left = null;
            }
            // go right
            node = node.right;
        }
    }
}
// @lc code=end
