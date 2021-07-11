import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.naming.LinkLoopException;
import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=199 lang=java
 *
 * [199] Binary Tree Right Side View
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
// class Solution {
// public List<Integer> rightSideView(TreeNode root) {
// List<Integer> res = new ArrayList<>();
// if (root == null)
// return res;

// // get each level's rightmost node
// Queue<TreeNode> q = new LinkedList<>();
// q.add(root);

// while (!q.isEmpty()) {
// int currLevelSize = q.size();
// for (int i = 0; i < currLevelSize; i++) {
// TreeNode node = q.poll();
// if (node.left != null) {
// q.add(node.left);
// }
// if (node.right != null) {
// q.add(node.right);
// }

// // add the last one (rightmost) to res
// if (i == currLevelSize - 1) {
// res.add(node.val);
// }
// }
// }

// return res;
// }
// }

class Solution {
    List<Integer> res = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    public void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }

        if (res.size() == depth) {
            res.add(root.val);
        }

        depth++;
        dfs(root.right, depth);
        dfs(root.left, depth);
    }
}

// @lc code=end
