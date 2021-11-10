/*
 * @lc app=leetcode id=129 lang=java
 *
 * [129] Sum Root to Leaf Numbers
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */

class Solution {
    // the answer will fit in a 32-bit integer.
    int sum;

    public int sumNumbers(TreeNode root) {
        sum = 0;
        // The depth of the tree will not exceed 10
        dfs(root, root.val);

        return sum;
    }

    public void dfs(TreeNode root, int num) {
        if (root.left == null && root.right == null) {
            sum += num;
        }

        if (root.left != null) {
            int next = num * 10 + root.left.val;
            dfs(root.left, next);
        }
        if (root.right != null) {
            int next = num * 10 + root.right.val;
            dfs(root.right, next);
        }
    }
}

// @lc code=end
