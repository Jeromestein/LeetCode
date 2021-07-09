/*
 * @lc app=leetcode id=111 lang=java
 *
 * [111] Minimum Depth of Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public int minDepth(TreeNode root) {
        // The minimum depth is the number of nodes along the shortest path
        // from the root node down to the nearest leaf node.
        if (root == null)
            return 0;

        int lHeight = minDepth(root.left);
        int rHeight = minDepth(root.right);
        if (lHeight == 0 && rHeight == 0) {
            return 1;
        } else if (lHeight == 0 && rHeight != 0) {
            return rHeight + 1;
        } else if (lHeight != 0 && rHeight == 0) {
            return lHeight + 1;
        } else {
            return Math.min(lHeight, rHeight) + 1;
        }

    }
}
// @lc code=end
