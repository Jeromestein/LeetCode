/*
 * @lc app=leetcode id=226 lang=java
 *
 * [226] Invert Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return root;

        if (root.left != null && root.right != null) {
            TreeNode temp = root.left;
            root.left = invertTree(root.right);
            root.right = invertTree(temp);
        } else if (root.left != null && root.right == null) {
            root.right = invertTree(root.left);
            root.left = null;
        } else if (root.left == null && root.right != null) {
            root.left = invertTree(root.right);
            root.right = null;
        }

        return root;
    }
}

// @lc code=end
