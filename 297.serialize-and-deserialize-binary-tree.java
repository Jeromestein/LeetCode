import java.util.PriorityQueue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=297 lang=java
 *
 * [297] Serialize and Deserialize Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Codec {
    // is that ok???
    private static int index;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(sb, root);

        return sb.toString();
    }

    private void buildString(StringBuilder sb, TreeNode root) {
        if (root == null) {
            // String[] res = data.split(","); in deserialize()
            // so no mater how many ","
            sb.append("null").append(",");
        } else {
            sb.append(root.val).append(",");
            buildString(sb, root.left);
            buildString(sb, root.right);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        index = 0;
        String[] res = data.split(",");

        return buildTree(res);
    }

    private TreeNode buildTree(String[] res) {
        String p = res[index++];
        if (p.equals("null")) {
            return null;
        }

        // pre order
        TreeNode root = new TreeNode(Integer.parseInt(p));
        root.left = buildTree(res);
        root.right = buildTree(res);

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
// @lc code=end
