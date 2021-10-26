import java.util.Map;
import java.util.Queue;

/*
 * @lc app=leetcode id=314 lang=java
 *
 * [314] Binary Tree Vertical Order Traversal
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */

class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        if (root == null) {
            return res;
        }

        Map<Integer, ArrayList> columns = new HashMap();
        // Pair of node and its column offset
        Queue<Pair<TreeNode, Integer>> queue = new ArrayDeque();
        int idx = 0;
        queue.add(new Pair(root, idx));

        int minColumn = 0, maxColumn = 0;

        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> p = queue.poll();
            root = p.getKey();
            idx = p.getValue();

            if (root != null) {
                // colums[idx].add(root.val)
                columns.computeIfAbsent(idx, v -> new ArrayList<>()).add(root.val);
                // updatae left bound and right bound
                minColumn = Math.min(minColumn, idx);
                maxColumn = Math.max(maxColumn, idx);

                queue.add(new Pair(root.left, idx - 1));
                queue.add(new Pair(root.right, idx + 1));
            }
        }

        for (int i = minColumn; i <= maxColumn; i++) {
            res.add(columns.get(i));
        }

        return res;
    }
}

// @lc code=end
