import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=113 lang=java
 *
 * [113] Path Sum II
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */

// // 8ms, 5%, 5%.
// class Solution {
// List<List<Integer>> ret = new LinkedList<List<Integer>>();
// // adjacent list, <child, father>
// // save the path from leaf to root
// Map<TreeNode, TreeNode> map = new HashMap<TreeNode, TreeNode>();

// public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
// if (root == null) {
// return ret;
// }

// Queue<TreeNode> queueNode = new LinkedList<TreeNode>();
// Queue<Integer> queueSum = new LinkedList<Integer>();
// queueNode.offer(root);
// queueSum.offer(0);

// while (!queueNode.isEmpty()) {
// TreeNode node = queueNode.poll();
// int rec = queueSum.poll() + node.val;

// if (node.left == null && node.right == null) {
// if (rec == targetSum) {
// getPath(node);
// }
// } else {
// if (node.left != null) {
// map.put(node.left, node);
// queueNode.offer(node.left);
// queueSum.offer(rec);
// }
// if (node.right != null) {
// map.put(node.right, node);
// queueNode.offer(node.right);
// queueSum.offer(rec);
// }
// }
// }

// return ret;
// }

// public void getPath(TreeNode node) {
// List<Integer> temp = new LinkedList<Integer>();
// while (node != null) {
// temp.add(node.val);
// node = map.get(node);
// }
// Collections.reverse(temp);
// ret.add(new LinkedList<Integer>(temp));
// }
// }

class Solution {
    List<List<Integer>> res = new LinkedList<List<Integer>>();
    Deque<Integer> pathStack = new LinkedList<Integer>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return res;
    }

    public void dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        // if use push pop, we will get [[2,11,4,5],[5,4,8,5]]
        // rather than [[5,4,11,2],[5,8,4,5]] by using add, pollLast
        pathStack.add(root.val);
        targetSum -= root.val;
        if (root.left == null && root.right == null && targetSum == 0) {
            res.add(new LinkedList<Integer>(pathStack));
        }
        dfs(root.left, targetSum);
        dfs(root.right, targetSum);
        // remove the last one
        pathStack.pollLast();
    }
}
// @lc code=end
