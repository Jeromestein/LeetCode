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
    Map<Integer, ArrayList<Pair<Integer, Integer>>> colTable = new HashMap<>();
    int minCol = 0, maxCol = 0;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        // 1. dfs, get all the elements in colTable
        dfs(root, 0, 0);
        // 2. for each colum, sort colTable
        for (int i = minCol; i <= maxCol; i++) {
            Collections.sort(colTable.get(i), new Comparator<Pair<Integer, Integer>>() {
                @Override
                public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
                    if (p1.getKey() == p2.getKey())
                        // ascending order
                        return p1.getValue() - p2.getValue();
                    else
                        // ascending order
                        return p1.getKey() - p2.getKey();
                }
            });

            // 3. convert from colTable to 2D list
            List<Integer> sortedCol = new ArrayList<>();
            for (Pair<Integer, Integer> p : colTable.get(i)) {
                sortedCol.add(p.getValue());
            }
            res.add(sortedCol);
        }

        return res;
    }

    private void dfs(TreeNode root, int row, int col) {
        if (root == null)
            return;

        colTable.computeIfAbsent(col, k -> new ArrayList<Pair<Integer, Integer>>());
        colTable.get(col).add(new Pair<Integer, Integer>(row, root.val));

        minCol = Math.min(minCol, col);
        maxCol = Math.max(maxCol, col);

        dfs(root.left, row + 1, col - 1);
        dfs(root.right, row + 1, col + 1);

    }
}

// @lc code=end
