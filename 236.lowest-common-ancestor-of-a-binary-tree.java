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
    // adjacent list <child, father>
    Map<TreeNode, TreeNode> adjList = new HashMap<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        // bfs starting from root, create adjacent list and find p and q
        queue.add(root);

        boolean isFound_p = false;
        boolean isFound_q = false;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == p) {
                isFound_p = true;
            }
            if (node == q) {
                isFound_q = true;
            }

            if (isFound_p == true && isFound_q == true) {
                break;
            }

            if (node.left != null) {
                // create adjacent list
                adjList.put(node.left, node);
                queue.add(node.left);
            }
            if (node.right != null) {
                // create adjacent list
                adjList.put(node.right, node);
                queue.add(node.right);
            }
        }

        return getLCA(root, p, q);
    }

    public TreeNode getLCA(TreeNode root, TreeNode p, TreeNode q) {
        // get the length of linklist of p and q (from p/q to root)
        int pLen = 1, qLen = 1;
        TreeNode node = p;
        while (node != root) {
            node = adjList.get(node);
            pLen++;
        }
        node = q;
        while (node != root) {
            node = adjList.get(node);
            qLen++;
        }

        if (pLen > qLen) {
            while (pLen != qLen) {
                p = adjList.get(p);
                pLen--;
            }
        }
        if (pLen < qLen) {
            while (pLen != qLen) {
                q = adjList.get(q);
                qLen--;
            }
        }

        while (p != q) {
            p = adjList.get(p);
            q = adjList.get(q);
        }

        return p;
    }
}
// @lc code=end
