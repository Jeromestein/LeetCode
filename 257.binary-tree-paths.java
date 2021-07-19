import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=257 lang=java
 *
 * [257] Binary Tree Paths
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();

        dfs(root, res, new StringBuilder());
        return res;
    }

    public void dfs(TreeNode root, List<String> res, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.append(root.val);
        if (root.left == null && root.right == null) {

            res.add(sb.toString());
            return;
        } else {
            sb.append("->");
            // store current string length
            int idx = sb.length();

            dfs(root.left, res, sb);
            // remove reduntant part (child imformation)
            sb.delete(idx, sb.length());

            dfs(root.right, res, sb);
            sb.delete(idx, sb.length());
        }

    }
}
// @lc code=end
