import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=513 lang=java
 *
 * [513] Find Bottom Left Tree Value
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    // public int findBottomLeftValue(TreeNode root) {
    // Queue<TreeNode> q = new LinkedList<>();

    // if (root != null)
    // q.add(root);

    // int res = root.val;
    // while (!q.isEmpty()) {
    // TreeNode node = q.poll();
    // // only store the first left node val of each level
    // res = node.val;

    // // enque right node first,
    // // so the fisrt left node will be the last one
    // if (node.right != null) {
    // q.add(node.right);
    // }
    // if (node.left != null) {
    // q.add(node.left);
    // }

    // }
    // return res;
    // }

    int max = -1;
    int value = 0;

    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);
        return value;
    }

    public void dfs(TreeNode root, int level) {
        if (root == null)
            return;
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
        if (level > max) {
            // only store the first left node val of each level
            max = level;
            value = root.val;
        }
    }
}
// @lc code=end
