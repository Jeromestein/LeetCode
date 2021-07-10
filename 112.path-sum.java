import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

import jdk.nashorn.api.tree.Tree;

/*
 * @lc app=leetcode id=112 lang=java
 *
 * [112] Path Sum
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
// class Solution {
// public boolean hasPathSum(TreeNode root, int targetSum) {
// if (root == null) {
// return false;
// }
// Queue<TreeNode> nodeQ = new LinkedList<>();
// Queue<Integer> sumQ = new LinkedList<>();
// nodeQ.add(root);
// sumQ.add(root.val);

// while (!nodeQ.isEmpty()) {
// int currLevelSize = nodeQ.size();
// for (int i = 0; i < currLevelSize; i++) {
// TreeNode node = nodeQ.poll();
// int valSum = sumQ.poll();
// if (node.left == null && node.right == null) {
// if (valSum == targetSum) {
// return true;
// }
// }
// if (node.left != null) {
// nodeQ.add(node.left);
// sumQ.add(valSum + node.left.val);
// }
// if (node.right != null) {
// nodeQ.add(node.right);
// sumQ.add(valSum + node.right.val);
// }
// }
// }

// return false;
// }
// }

class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        int nextSum = targetSum - root.val;
        if (root.left == null && root.right == null) {
            return nextSum == 0;
        }

        return hasPathSum(root.left, nextSum) || hasPathSum(root.right, nextSum);
    }
}
// @lc code=end
