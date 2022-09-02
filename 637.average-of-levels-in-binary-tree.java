/*
 * @lc app=leetcode id=637 lang=java
 *
 * [637] Average of Levels in Binary Tree
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
    public List<Double> averageOfLevels(TreeNode root) {
        // 1. use bfs to do level traversal
        Queue<TreeNode> q = new LinkedList<>();
        List<Double> res = new ArrayList<>();

        q.add(root);

        while (!q.isEmpty()) {
            int cnt = q.size();
            double sum = 0;
            for (int i = 0; i < cnt; i++) {
                TreeNode curr = q.poll();
                sum += curr.val;

                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }

            res.add(sum / cnt);
            sum = 0;
            cnt = 0;
        }

        return res;
    }
}
// @lc code=end
