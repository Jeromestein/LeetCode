import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import javax.swing.tree.TreeNode;

import jdk.nashorn.api.tree.IfTree;

/*
 * @lc app=leetcode id=144 lang=java
 *
 * [144] Binary Tree Preorder Traversal
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
// class Solution {
// public List<Integer> preorderTraversal(TreeNode root) {
// List<Integer> res = new ArrayList<>();
// preorder(root, res);

// return res;
// }

// public void preorder(TreeNode root, List<Integer> res) {
// if (root == null) {
// return;
// }
// res.add(root.val);
// preorder(root.left, res);
// preorder(root.right, res);
// }
// }

// class Solution {
// public List<Integer> preorderTraversal(TreeNode root) {
// List<Integer> res = new ArrayList<>();
// Deque<TreeNode> stack = new LinkedList<>();

// while (root != null || !stack.isEmpty()) {
// while (root != null) {
// res.add(root.val);
// stack.push(root);
// root = root.left;
// }
// root = stack.pop();
// root = root.right;
// }

// return res;
// }
// }

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        TreeNode node = root, pre = null;

        while (node != null) {
            pre = node.left;
            if (pre != null) {
                while (pre.right != null && pre.right != node) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    res.add(node.val);
                    pre.right = node;
                    node = node.left;
                    continue;
                } else {
                    pre.right = null;
                }
            } else {
                res.add(node.val);
            }
            node = node.right;
        }
        return res;
    }
}
// @lc code=end
