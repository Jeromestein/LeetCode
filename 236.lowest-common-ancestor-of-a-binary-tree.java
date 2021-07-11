import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=236 lang=java
 *
 * [236] Lowest Common Ancestor of a Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q)
            return root;

        if (root == null)
            return null;

        TreeNode lNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rNode = lowestCommonAncestor(root.right, p, q);

        if (lNode != null && rNode != null) {
            // one in left subtree, another in right subtree
            return root;
        } else if (lNode == null) {
            // left sbutree is empty, both of two maybe in right subtree
            return rNode;
        } else {
            // left sbutree is not empty and right sbutree is empty,
            // both of two maybe in left subtree
            return lNode;
        }

    }
}
// @lc code=end
