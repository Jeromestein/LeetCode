import java.util.Deque;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=98 lang=java
 *
 * [98] Validate Binary Search Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
// class Solution {
// public boolean isValidBST(TreeNode root) {
// return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
// }

// // -2^31 <= Node.val <= 2^31 - 1
// // so use long type rather than in
// public boolean isValidBST(TreeNode root, long lowerBound, long upperBound) {
// if (root == null)
// return true;

// // The left subtree of a node contains only nodes
// // with keys less than the node's key.
// // The right subtree of a node contains only nodes
// // with keys greater than the node's key.
// // so don't forget '='
// if (root.val <= lowerBound || root.val >= upperBound)
// return false;

// return isValidBST(root.left, lowerBound, root.val) && isValidBST(root.right,
// root.val, upperBound);
// }
// }

class Solution {
    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        long preVal = Long.MIN_VALUE;

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (preVal >= root.val)
                return false;
            preVal = root.val;
            root = root.right;
        }

        return true;
    }
}
// @lc code=end
