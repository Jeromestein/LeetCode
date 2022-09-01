/*
 * @lc app=leetcode id=298 lang=java
 *
 * [298] Binary Tree Longest Consecutive Sequence
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
    int maxConSeq = 0;

    public int longestConsecutive(TreeNode root) {
        // dfs
        // -3 * 10^4 <= Node.val <= 3 * 10^4
        dfs(root, 0, -30005);

        return maxConSeq;
    }

    private void dfs(TreeNode root, int currConSeq, int preVal) {
        if (root.val == preVal + 1) {
            currConSeq++;
        } else {
            currConSeq = 1;
        }
        preVal = root.val;
        maxConSeq = Math.max(maxConSeq, currConSeq);

        if (root.left != null)
            dfs(root.left, currConSeq, preVal);

        if (root.right != null)
            dfs(root.right, currConSeq, preVal);
    }
}
// @lc code=end
