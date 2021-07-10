import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

import jdk.nashorn.internal.ir.TryNode;

/*
 * @lc app=leetcode id=104 lang=java
 *
 * [104] Maximum Depth of Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int depth = 1, maxDepth = 0;
        while (!q.isEmpty()) {
            int currLevelSize = q.size();
            for (int i = 0; i < currLevelSize; i++) {
                TreeNode node = q.poll();
                if (node.left == null && node.right == null) {
                    maxDepth = depth;
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

        return maxDepth;
    }
}
// @lc code=end
