import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import javax.swing.tree.TreeNode;

import jdk.nashorn.internal.ir.TryNode;

/*
 * @lc app=leetcode id=145 lang=java
 *
 * [145] Binary Tree Postorder Traversal
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
// class Solution {
// public List<Integer> postorderTraversal(TreeNode root) {
// List<Integer> res = new ArrayList<>();
// postorder(root, res);

// return res;
// }

// public void postorder(TreeNode root, List<Integer> res) {
// if (root == null) {
// return;
// }
// postorder(root.left, res);
// postorder(root.right, res);
// res.add(root.val);
// }
// }

// class Solution {
// public List<Integer> postorderTraversal(TreeNode root) {
// List<Integer> res = new ArrayList<>();
// Deque<TreeNode> stack = new LinkedList<>();

// TreeNode pre = null;
// while (root != null || !stack.isEmpty()) {
// while (root != null) {
// stack.push(root);
// root = root.left;
// }

// root = stack.poll();
// if (root.right == null || root.right == pre) {
// res.add(root.val);
// pre = root;
// root = null;
// } else {
// stack.push(root);
// root = root.right;
// }

// }

// return res;
// }
// }

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        TreeNode node = root, pre = null;

        while (node != null) {
            if (node.left != null) {
                // find the rightmost in node's left subtree
                pre = node.left;
                while (pre.right != null && pre.right != node) {
                    pre = pre.right;
                }

                // if this rightmost's right point to null
                // then let this rightmost's right point to node
                // aka let this rightmost become node's prenode
                if (pre.right == null) {
                    pre.right = node;
                    // go left, move to next node
                    node = node.left;
                    // skip below "node = node.right;"
                    continue;
                } else {
                    // if his rightmost's right point to node,
                    // let it point to null
                    pre.right = null;
                    // add path this left subtree
                    addPath(res, node.left);
                }
            }
            // cannot use else!!! because the "continue;" above!!!
            node = node.right;
        }

        addPath(res, root);
        return res;
    }

    public void addPath(List<Integer> res, TreeNode node) {
        // get the size of both left and right subtree
        int count = 0;
        while (node != null) {
            count++;
            res.add(node.val);
            node = node.right;
        }
        int leftSubtreeSize = res.size() - count, rightSubtreeSize = res.size() - 1;

        while (leftSubtreeSize < rightSubtreeSize) {
            // swap
            int temp = res.get(leftSubtreeSize);
            res.set(leftSubtreeSize, res.get(rightSubtreeSize));
            res.set(rightSubtreeSize, temp);
            leftSubtreeSize++;
            rightSubtreeSize--;
        }
    }
}
// @lc code=end
