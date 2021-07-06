import java.util.HashMap;
import java.util.Map;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=105 lang=java
 *
 * [105] Construct Binary Tree from Preorder and Inorder Traversal
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    int n;
    Map<Integer, Integer> indexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        n = inorder.length;
        indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }

        return buildTreePreIn(preorder, 0, n - 1, inorder, 0, n - 1);
    }

    public TreeNode buildTreePreIn(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }

        int preoRoot = preStart;
        int inRoot = indexMap.get(preorder[preoRoot]);

        TreeNode root = new TreeNode(preorder[preoRoot]);
        int leftSubtreeSize = inRoot - inStart;

        root.left = buildTreePreIn(preorder, preStart + 1, preStart + leftSubtreeSize, inorder, inStart, inRoot - 1);
        root.right = buildTreePreIn(preorder, preStart + leftSubtreeSize + 1, preEnd, inorder, inRoot + 1, inEnd);
        return root;
    }
}
// @lc code=end
