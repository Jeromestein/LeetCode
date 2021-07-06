import java.util.HashMap;
import java.util.Map;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=106 lang=java
 *
 * [106] Construct Binary Tree from Inorder and Postorder Traversal
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
    int[] inorder, postorder;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        n = inorder.length;
        indexMap = new HashMap<>();
        this.inorder = inorder;
        this.postorder = postorder;

        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }

        return buildTreeInPost(0, n - 1, 0, n - 1);
    }

    public TreeNode buildTreeInPost(int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd) {
            return null;
        }

        int postRoot = postEnd;
        int inRoot = indexMap.get(postorder[postRoot]);

        TreeNode root = new TreeNode(postorder[postRoot]);
        int rightSubtreeSize = inEnd - inRoot;

        root.left = buildTreeInPost(inStart, inRoot - 1, postStart, postEnd - rightSubtreeSize - 1);
        root.right = buildTreeInPost(inRoot + 1, inEnd, postEnd - rightSubtreeSize, postEnd - 1);

        return root;
    }
}

// @lc code=end
