/*
 * @lc app=leetcode id=270 lang=java
 *
 * [270] Closest Binary Search Tree Value
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */

class Solution {
    int res;
    double target;

    public int closestValue(TreeNode root, double target) {
        this.res = root.val;
        this.target = target;
        dfs(root);

        return res;

    }

    public void dfs(TreeNode root) {
        if (root == null)
            return;

        if (Math.abs((double) root.val - target) < Math.abs((double) res - target)) {
            res = root.val;
        }

        dfs(root.left);
        dfs(root.right);
    }
}

// @lc code=end
