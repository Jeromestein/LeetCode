/*
 * @lc app=leetcode id=1457 lang=java
 *
 * [1457] Pseudo-Palindromic Paths in a Binary Tree
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
    int cnt = 0;

    public void preorder(TreeNode node, int path) {
        if (node != null) {
            // compute occurences of each digit
            // in the corresponding register
            path = path ^ (1 << node.val);
            // if it's a leaf check if the path is pseudo-palindromic
            if (node.left == null && node.right == null) {
                // check if at most one digit has an odd frequency
                // use x&(x-1) again:
                // check the article Power of Two for the detailed explanation of this bitwise
                // trick.
                if ((path & (path - 1)) == 0) {
                    cnt++;
                }
            }
            preorder(node.left, path);
            preorder(node.right, path);
        }
    }

    public int pseudoPalindromicPaths(TreeNode root) {
        preorder(root, 0);
        return cnt;
    }
}
// @lc code=end
