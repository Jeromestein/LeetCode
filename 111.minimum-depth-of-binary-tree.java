import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

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
// class Solution {
// public int minDepth(TreeNode root) {
// // The minimum depth is the number of nodes along the shortest path
// // from the root node down to the nearest leaf node.
// if (root == null)
// return 0;

// if (root.left == null && root.right == null) {
// // leaf node
// return 1;
// } else if (root.left == null && root.right != null) {
// // no left child
// return minDepth(root.right) + 1;
// } else if (root.left != null && root.right == null) {
// // no right child
// return minDepth(root.left) + 1;
// } else {
// return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
// }

// }
// }

class Solution {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            // leaf node
            return 1;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int depth = 1;
        // level order traversal
        while (!q.isEmpty()) {
            int currLevelSize = q.size();
            for (int i = 0; i < currLevelSize; i++) {
                TreeNode node = q.poll();
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
// @lc code=end
