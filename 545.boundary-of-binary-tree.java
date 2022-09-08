/*
 * @lc app=leetcode id=545 lang=java
 *
 * [545] Boundary of Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        // root
        res.add(root.val);
        if (root.left == null && root.right == null)
            return res;

        // left boundary
        if (root.left != null) {
            res.addAll(getLeftBoundary(root.left));
        }
        // leaves
        res.addAll(getLeaves(root));
        // reverse order right boundary
        if (root.right != null) {
            List<Integer> rightBoundary = getRightBoundary(root.right);
            Collections.reverse(rightBoundary);
            res.addAll(rightBoundary);
        }

        return res;
    }

    private List<Integer> getLeftBoundary(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root.left == null && root.right == null)
            return res;

        if (root.left != null) {
            res.add(root.val);
            res.addAll(getLeftBoundary(root.left));
        } else if (root.right != null) {
            res.add(root.val);
            res.addAll(getLeftBoundary(root.right));
        }

        return res;
    }

    private List<Integer> getLeaves(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        // use stack, inorder traversal, get leaves
        Stack<TreeNode> st = new Stack<>();
        while (!st.isEmpty() || root != null) {
            while (root != null) {
                st.push(root);
                root = root.left;
            }

            root = st.pop();
            if (root.left == null && root.right == null) {
                res.add(root.val);
            }
            root = root.right;
        }

        return res;
    }

    private List<Integer> getRightBoundary(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root.left == null && root.right == null)
            return res;

        if (root.right != null) {
            res.add(root.val);
            res.addAll(getRightBoundary(root.right));
        } else if (root.left != null) {
            res.add(root.val);
            res.addAll(getRightBoundary(root.left));
        }

        return res;
    }
}
// @lc code=end
