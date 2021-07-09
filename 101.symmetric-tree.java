/*
 * @lc app=leetcode id=101 lang=java
 *
 * [101] Symmetric Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    // if two tree start from lRoot and rRoot is Symmetric
    public boolean isSymmetric(TreeNode lRoot, TreeNode rRoot) {
        if (lRoot == null && rRoot == null)
            return true;
        if (lRoot == null ^ rRoot == null)
            return false;
        if (lRoot.val != rRoot.val)
            return false;

        return isSymmetric(lRoot.left, rRoot.right) && isSymmetric(lRoot.right, rRoot.left);
    }
}
// @lc code=end
