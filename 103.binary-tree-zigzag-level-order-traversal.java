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
        Queue<TreeNode> deque = new LinkedList<>();
        int levelCNT = 0;
        if (root != null) {
            deque.add(root);
        }

        while (!deque.isEmpty()) {
            // LinkedList is faster than Deque
            LinkedList<Integer> currLevel = new LinkedList<>();
            int currLevelSize = deque.size();

            for (int i = 0; i < currLevelSize; i++) {
                TreeNode node = deque.poll();

                if (levelCNT % 2 == 0) {
                    // if levelCNT is even
                    // then traverse node from left to right
                    currLevel.addLast(node.val);
                } else {
                    // else
                    // then traverse node from right to left
                    currLevel.addFirst(node.val);
                }

                if (node.left != null) {
                    deque.add(node.left);
                }
                if (node.right != null) {
                    deque.add(node.right);
                }
            }

            levelCNT++;
            res.add(currLevel);

        }

        return res;
    }
}
// @lc code=end
