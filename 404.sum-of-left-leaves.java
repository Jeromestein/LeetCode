/*
 * @lc app=leetcode id=404 lang=java
 *
 * [404] Sum of Left Leaves
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    int sum;

    public int sumOfLeftLeaves(TreeNode root) {
        // 1. walk through all the nodes, find the left leaves O(n)
        // how to identify the left leace
        // check left: dfs(node, left) or dfs (node, right)
        // check leaves: if (left==null&&riget==null)
        // 2. add them
        sum = 0;
        dfs(root, false);
        return sum;
    }

    public void dfs(TreeNode root, boolean isLeft) {
        if (isLeft && root.left == null && root.right == null) {
            sum += root.val;
        }

        if (root.left != null) {
            dfs(root.left, true);
        }
        if (root.right != null) {
            dfs(root.right, false);
        }
    }
}
// @lc code=end
