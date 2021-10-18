/*
 * @lc app=leetcode id=938 lang=java
 *
 * [938] Range Sum of BST
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */

class Solution {
    int sum, low, high;

    public int rangeSumBST(TreeNode root, int low, int high) {
        sum = 0;
        this.low = low;
        this.high = high;

        dfs(root);

        return sum;
    }

    public void dfs(TreeNode root) {
        if (root == null)
            return;

        if (root.val < low) {
            dfs(root.right);
        } else if (root.val > high) {
            dfs(root.left);
        } else {
            sum += root.val;
            dfs(root.left);
            dfs(root.right);
        }

    }
}

// @lc code=end
