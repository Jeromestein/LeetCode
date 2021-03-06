/*
 * @lc app=leetcode id=110 lang=java
 *
 * [110] Balanced Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
// class Solution {
// public boolean isBalanced(TreeNode root) {
// if (root == null)
// return true;
// int lHeight = getHeight(root.left);
// int rHeight = getHeight(root.right);
// int diff = Math.abs(lHeight - rHeight);

// return diff <= 1 && isBalanced(root.left) && isBalanced(root.right);
// }

// public int getHeight(TreeNode root) {
// if (root == null)
// return 0;

// return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
// }
// }

class Solution {
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    public int getHeight(TreeNode root) {
        if (root == null)
            return 0;
        int lHeight = getHeight(root.left);
        int rHeight = getHeight(root.right);
        int diff = Math.abs(lHeight - rHeight);
        if (lHeight == -1 || rHeight == -1 || diff > 1) {
            return -1;
        } else {
            return Math.max(lHeight, rHeight) + 1;
        }
    }
}

// @lc code=end
