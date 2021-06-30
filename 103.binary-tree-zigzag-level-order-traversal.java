import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=103 lang=java
 *
 * [103] Binary Tree Zigzag Level Order Traversal
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        int levelCNT = 0;
        if (root != null) {
            deque.add(root);
        }

        while (!deque.isEmpty()) {
            List<Integer> currLevel = new ArrayList<>();
            int currLevelSize = deque.size();

            if (levelCNT % 2 == 0) {
                // if levelCNT is even
                // then traverse node from left to right
                for (int i = 0; i < currLevelSize; i++) {
                    TreeNode node = deque.poll();
                    currLevel.add(node.val);

                    if (node.left != null) {
                        deque.add(node.left);
                    }
                    if (node.right != null) {
                        deque.add(node.right);
                    }
                }
            } else {
                // traverse node from right to left
                for (int i = currLevelSize - 1; i >= 0; i--) {
                    TreeNode node = deque.pollLast();

                    currLevel.add(node.val);
                    if (node.right != null) {
                        deque.addFirst(node.right);
                    }
                    if (node.left != null) {
                        deque.addFirst(node.left);
                    }

                }
            }
            levelCNT++;
            res.add(currLevel);

        }

        return res;
    }
}
// @lc code=end
