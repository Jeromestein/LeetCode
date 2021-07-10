import java.util.ArrayList;
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
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> nodeQ = new LinkedList<>();
        Queue<Integer> sumQ = new LinkedList<>();
        Queue<List<Integer>> listQ = new LinkedList<>();
        nodeQ.add(root);
        sumQ.add(root.val);
        List<Integer> tmpList = new ArrayList<>();
        tmpList.add(root.val);
        listQ.add(tmpList);

        while (!nodeQ.isEmpty()) {
            int currLevelSize = nodeQ.size();
            for (int i = 0; i < currLevelSize; i++) {
                TreeNode node = nodeQ.poll();
                int sum = sumQ.poll();
                List<Integer> list = listQ.poll();
                if (node.left == null && node.right == null) {
                    if (sum == targetSum) {
                        res.add(list);
                    }
                }
                if (node.left != null) {
                    nodeQ.add(node.left);
                    sumQ.add(node.left.val + sum);
                    // first, deep copy list to lList
                    List<Integer> lList = new ArrayList<>();
                    lList.addAll(list);
                    // second, add node.left.val
                    lList.add(node.left.val);
                    listQ.add(lList);
                }
                if (node.right != null) {
                    nodeQ.add(node.right);
                    sumQ.add(node.right.val + sum);
                    // first, deep copy list to rList
                    List<Integer> rList = new ArrayList<>();
                    rList.addAll(list);
                    // second, add node.right.val
                    rList.add(node.right.val);
                    listQ.add(rList);
                }
            }
        }

        return res;
    }
}
// @lc code=end
