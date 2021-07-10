/*
 * @lc app=leetcode id=124 lang=java
 *
 * [124] Binary Tree Maximum Path Sum
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    int maxPathSum = Integer.MIN_VALUE;;

    public int maxPathSum(TreeNode root) {
        // the path can have only one node!!!
        getMaxSum(root);

        return maxPathSum;
    }

    public int getMaxSum(TreeNode root) {
        if (root == null)
            return 0;

        // the path can have only one node!!!
        // so we only count those positive val
        int lMaxSum = Math.max(getMaxSum(root.left), 0);
        int rMaxSum = Math.max(getMaxSum(root.right), 0);
        int maxSum = root.val;
        if (lMaxSum > rMaxSum) {
            maxSum += lMaxSum;
            maxPathSum = Math.max(maxPathSum, maxSum + rMaxSum);
        } else {
            maxSum += rMaxSum;
            maxPathSum = Math.max(maxPathSum, maxSum + lMaxSum);
        }
        return maxSum;
    }
}
// @lc code=end
