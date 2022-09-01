/*
 * @lc app=leetcode id=1448 lang=java
 *
 * [1448] Count Good Nodes in Binary Tree
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
    /*
     * With tree traversals, algorithms usually follow the same pattern:
     * 
     * 1. Do something with the current node
     * 2. Add the current node's children to the stack or queue being used for the
     * traversal
     * 3. Move on to the next node
     */
    int numGood = 0;

    public int goodNodes(TreeNode root) {
        // Each node's value is between [-10^4, 10^4].
        dfs(root, -10001);

        return numGood;
    }

    private void dfs(TreeNode root, int currGood) {
        if (currGood <= root.val)
            numGood++;

        if (root.left != null)
            dfs(root.left, Math.max(root.val, currGood));
        if (root.right != null)
            dfs(root.right, Math.max(root.val, currGood));

    }
}
// @lc code=end
