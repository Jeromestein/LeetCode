/*
 * @lc app=leetcode id=101 lang=java
 *
 * [101] Symmetric Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
// class Solution {
// public boolean isSymmetric(TreeNode root) {
// return isSymmetric(root.left, root.right);
// }

// // if two tree start from lRoot and rRoot is Symmetric
// public boolean isSymmetric(TreeNode lRoot, TreeNode rRoot) {
// if (lRoot == null && rRoot == null)
// return true;
// if (lRoot == null ^ rRoot == null)
// return false;
// if (lRoot.val != rRoot.val)
// return false;

// return isSymmetric(lRoot.left, rRoot.right) && isSymmetric(lRoot.right,
// rRoot.left);
// }
// }

class Solution {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> lQueue = new LinkedList<>();
        Queue<TreeNode> rQueue = new LinkedList<>();
        lQueue.add(root);
        rQueue.add(root);
        while (!lQueue.isEmpty() && !rQueue.isEmpty()) {
            TreeNode lNode = lQueue.poll();
            TreeNode rNode = rQueue.poll();
            if (lNode.val != rNode.val)
                return false;

            if (lNode.left == null ^ rNode.right == null) {
                // node1.left != null && node2.left == null ||
                // node1.left == null && node2.left != null
                return false;
            } else if (lNode.left != null && rNode.right != null) {
                lQueue.add(lNode.left);
                rQueue.add(rNode.right);
            }
            if (lNode.right == null ^ rNode.left == null) {
                // node1.right != null && node2.right == null ||
                // node1.right == null && node2.right != null
                return false;
            } else if (lNode.right != null && rNode.left != null) {
                lQueue.add(lNode.right);
                rQueue.add(rNode.left);
            }
        }
        return lQueue.isEmpty() && rQueue.isEmpty();
    }
}
// @lc code=end
