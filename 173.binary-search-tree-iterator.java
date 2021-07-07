import java.util.Deque;
import java.util.LinkedList;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=173 lang=java
 *
 * [173] Binary Search Tree Iterator
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class BSTIterator {
    TreeNode currNode;
    Deque<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        currNode = root;
        stack = new LinkedList<>();
    }

    public int next() {
        while (currNode != null) {
            stack.push(currNode);
            currNode = currNode.left;
        }
        currNode = stack.pop();
        int res = currNode.val;
        currNode = currNode.right;

        return res;
    }

    public boolean hasNext() {
        return currNode != null || !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such: BSTIterator
 * obj = new BSTIterator(root); int param_1 = obj.next(); boolean param_2 =
 * obj.hasNext();
 */
// @lc code=end
