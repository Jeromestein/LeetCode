/*
 * @lc app=leetcode id=814 lang=java
 *
 * [814] Binary Tree Pruning
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if (root.left != null)
            root.left = pruneTree(root.left);
        if (root.right != null)
            root.right = pruneTree(root.right);

        // firat dfs, mark all the subtree not containing 1

        // second dfs, prune
        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        } else
            return root;
    }
}

// @lc code=end
