import java.sql.PseudoColumnUsage;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=100 lang=java
 *
 * [100] Same Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
// class Solution {
// public boolean isSameTree(TreeNode p, TreeNode q) {
// if (p == null && q == null)
// return true;
// if (p == null ^ q == null)
// // ^: xor
// // p != null && q == null || p == null && q != null
// return false;

// Queue<TreeNode> pQueue = new LinkedList<>();
// Queue<TreeNode> qQueue = new LinkedList<>();
// pQueue.add(p);
// qQueue.add(q);
// while (!pQueue.isEmpty() && !qQueue.isEmpty()) {
// TreeNode node1 = pQueue.poll();
// TreeNode node2 = qQueue.poll();
// if (node1.val != node2.val)
// return false;

// if (node1.left == null ^ node2.left == null) {
// // node1.left != null && node2.left == null ||
// // node1.left == null && node2.left != null
// return false;
// } else if (node1.left != null && node2.left != null) {
// pQueue.add(node1.left);
// qQueue.add(node2.left);
// }

// if (node1.right == null ^ node2.right == null) {
// // node1.right != null && node2.right == null ||
// // node1.right == null && node2.right != null
// return false;
// } else if (node1.right != null && node2.right != null) {
// pQueue.add(node1.right);
// qQueue.add(node2.right);
// }
// }

// return pQueue.isEmpty() && qQueue.isEmpty();
// }
// }

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null ^ q == null)
            // ^: xor
            // p != null && q == null || p == null && q != null
            return false;

        if (p.val != q.val)
            return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
// @lc code=end
