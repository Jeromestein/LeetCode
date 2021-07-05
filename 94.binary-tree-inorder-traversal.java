import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=94 lang=java
 *
 * [94] Binary Tree Inorder Traversal
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
// class Solution {
// public List<Integer> inorderTraversal(TreeNode root) {
// List<Integer> res = new ArrayList<Integer>();
// inorder(root, res);
// return res;
// }

// public void inorder(TreeNode root, List<Integer> res) {
// if (root == null) {
// return;
// }
// inorder(root.left, res);
// res.add(root.val);
// inorder(root.right, res);
// }
// }

// class Solution {
// public List<Integer> inorderTraversal(TreeNode root) {
// List<Integer> res = new ArrayList<Integer>();
// Deque<TreeNode> stk = new LinkedList<TreeNode>();
// while (root != null || !stk.isEmpty()) {
// while (root != null) {
// stk.push(root);
// root = root.left;
// }
// root = stk.pop();
// res.add(root.val);
// root = root.right;
// }
// return res;
// }
// }

// class Solution {
// public List<Integer> inorderTraversal(TreeNode root) {
// List<Integer> res = new ArrayList<>();
// TreeNode curr = root;
// TreeNode pre;
// while (curr != null) {
// if (curr.left == null) {
// res.add(curr.val);
// curr = curr.right; // move to next right node
// } else { // has a left subtree
// pre = curr.left;
// while (pre.right != null) { // find rightmost
// pre = pre.right;
// }
// pre.right = curr; // put cur after the pre node
// TreeNode temp = curr; // store cur node
// curr = curr.left; // move cur to the top of the new tree
// temp.left = null; // original cur left be null, avoid infinite loops
// }
// }
// return res;
// }
// }

// class Solution {
// public List<Integer> inorderTraversal(TreeNode root) {
// List<Integer> res = new ArrayList<Integer>();
// TreeNode pre = null;

// while (root != null) {
// if (root.left != null) {
// pre = root.left;
// while (pre.right != null && pre.right != root) {
// pre = pre.right;
// }
// if (pre.right == null) {
// pre.right = root;
// root = root.left;
// } else {
// res.add(root.val);
// pre.right = null;
// root = root.right;
// }
// } else {
// res.add(root.val);
// root = root.right;
// }
// }
// return res;
// }
// }

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        TreeNode node = root, pre = null;

        while (node != null) {
            pre = node.left;
            if (pre != null) {
                while (pre.right != null && pre.right != node) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    pre.right = node;
                    node = node.left;
                    continue;
                } else {
                    res.add(node.val);
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
