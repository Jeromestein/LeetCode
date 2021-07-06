import javax.print.attribute.standard.PresentationDirection;
import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=889 lang=java
 *
 * [889] Construct Binary Tree from Preorder and Postorder Traversal
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    int n;
    int[] pre, post;

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        // It is guaranteed an answer exists.
        // If there exists multiple answers, you can return any of them.
        n = pre.length;
        this.pre = pre;
        this.post = post;

        return bulidTreePrePost(0, n - 1, 0, n - 1);
    }

    public TreeNode bulidTreePrePost(int preStart, int preEnd, int postStart, int postEnd) {
        if (preStart > preEnd || postStart > postEnd) {
            return null;
        }

        int preRoot = preStart;
        int postRoot = postEnd;
        TreeNode root = new TreeNode(pre[preRoot]);
        int leftSubtreeSize = 1;
        for (int i = postStart; preRoot < preEnd && i <= postEnd; i++) {
            if (post[i] == pre[preRoot + 1]) {
                leftSubtreeSize = i - postStart + 1;
                break;
            }
        }

        root.left = bulidTreePrePost(preStart + 1, preStart + leftSubtreeSize, postStart,
                postStart + leftSubtreeSize - 1);
        root.right = bulidTreePrePost(preStart + leftSubtreeSize + 1, preEnd, postStart + leftSubtreeSize, postEnd - 1);

        return root;
    }
}
// @lc code=end
