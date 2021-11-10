/*
 * @lc app=leetcode id=993 lang=java
 *
 * [993] Cousins in Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */

class Solution {
    int xDepth = 0, yDepth = 0;
    TreeNode xFather = null, yFather = null;
    int x, y;

    public boolean isCousins(TreeNode root, int x, int y) {
        // x != y
        if (root.val == x || root.val == y)
            return false;

        xFather = null;
        yFather = null;
        xDepth = 0;
        yDepth = 0;
        this.x = x;
        this.y = y;

        dfs(root, null, 0);

        // x and y are exist in the tree.
        if (xDepth == yDepth && xFather != yFather) {
            return true;
        } else {
            return false;
        }
    }

    public void dfs(TreeNode curr, TreeNode pre, int depth) {
        // Each node has a unique value.
        if (curr == null)
            return;

        if (curr.val == x) {
            xDepth = depth;
            xFather = pre;
        }
        if (curr.val == y) {
            yDepth = depth;
            yFather = pre;
        }

        dfs(curr.left, curr, depth + 1);
        dfs(curr.right, curr, depth + 1);
    }
}

// @lc code=end
