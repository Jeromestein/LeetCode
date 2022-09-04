import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=987 lang=java
 *
 * [987] Vertical Order Traversal of a Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */

class Solution {
    Map<Integer, ArrayList<Pair<Integer, Integer>>> colTable = new HashMap();
    int minColumn = 0, maxColumn = 0;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> output = new ArrayList();
        if (root == null) {
            return output;
        }

        // step 1). DFS traversal
        DFS(root, 0, 0);

        // step 2). retrieve the value from the columnTable
        for (int i = minColumn; i <= maxColumn; i++) {
            // order by both "row" and "value"
            Collections.sort(colTable.get(i), new Comparator<Pair<Integer, Integer>>() {
                @Override
                public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
                    if (p1.getKey().equals(p2.getKey()))
                        return p1.getValue() - p2.getValue();
                    else
                        return p1.getKey() - p2.getKey();
                }
            });

            List<Integer> sortedCol = new ArrayList();
            for (Pair<Integer, Integer> p : colTable.get(i)) {
                sortedCol.add(p.getValue());
            }
            output.add(sortedCol);
        }

        return output;
    }

    private void DFS(TreeNode node, Integer row, Integer col) {
        if (node == null)
            return;

        colTable.computeIfAbsent(col, k -> new ArrayList<Pair<Integer, Integer>>());
        colTable.get(col).add(new Pair<Integer, Integer>(row, node.val));
        minColumn = Math.min(minColumn, col);
        maxColumn = Math.max(maxColumn, col);
        // preorder DFS traversal
        DFS(node.left, row + 1, col - 1);
        DFS(node.right, row + 1, col + 1);
    }
}

// @lc code=end
