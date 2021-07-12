import java.util.Deque;
import java.util.LinkedList;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=449 lang=java
 *
 * [449] Serialize and Deserialize BST
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder strTree = new StringBuilder("");
        // pre order to store this tree
        String res = storeTreePre(root, strTree).toString();
        // System.out.println(res);
        return res;
    }

    public StringBuilder storeTreePre(TreeNode root, StringBuilder strTree) {
        if (root == null) {
            return strTree;
        }
        // pre order
        strTree.append(root.val);
        strTree.append(" ");
        storeTreePre(root.left, strTree);
        storeTreePre(root.right, strTree);

        return strTree;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // input is empty
        if (data.equals("")) {
            return null;
        }
        Deque<Integer> nodes = new LinkedList<>();
        for (String node : data.split(" ")) {
            nodes.add(Integer.valueOf(node));
        }

        // System.out.println(nodes);

        TreeNode root = buildTreePre(nodes, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return root;
    }

    public TreeNode buildTreePre(Deque<Integer> nodes, int lowerBound, int upperBound) {
        if (nodes.isEmpty()) {
            return null;
        }
        int val = nodes.pollFirst();
        if (val < lowerBound || upperBound < val) {
            nodes.addFirst(val);
            return null;
        }

        // pre order
        TreeNode root = new TreeNode(val);
        root.left = buildTreePre(nodes, lowerBound, val);
        root.right = buildTreePre(nodes, val, upperBound);

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
// @lc code=end
