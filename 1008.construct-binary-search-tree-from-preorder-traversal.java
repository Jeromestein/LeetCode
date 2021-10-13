/*
 * @lc app=leetcode id=1008 lang=java
 *
 * [1008] Construct Binary Search Tree from Preorder Traversal
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */

class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {

        return buildTree(preorder, 0, preorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int left, int right) {
        if (left > right)
            return null;

        TreeNode root = new TreeNode(preorder[left]);
        // find first greater than root
        // All the values of preorder are unique.
        int mid = left + 1;
        while (mid <= right && preorder[mid] <= preorder[left]) {
            mid++;
        }
        root.left = buildTree(preorder, left + 1, mid - 1);
        root.right = buildTree(preorder, mid, right);

        return root;
    }
}

// @lc code=end
