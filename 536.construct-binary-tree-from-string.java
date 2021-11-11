/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public TreeNode str2tree(String s) {
        // s: val (s1)(s2)
        // root.val=val, root.left=str2tree(s1), root.right=str2tree(s2);

        // 1. get val
        int i = 0, n = s.length();
        if (n == 0)
            return null;

        while (i < n && s.charAt(i) != '(') {
            i++;
        }
        int val = Integer.valueOf(s.substring(0, i));
        TreeNode root = new TreeNode(val);
        // 2. get s1 if exists
        int start1 = i, end1 = start1 + 1, start2, end2;
        int lcnt = 0;
        for (; i < n; i++) {
            if (s.charAt(i) == '(') {
                lcnt++;
            }
            if (s.charAt(i) == ')') {
                if (lcnt == 1) {
                    end1 = i;
                    start2 = end1;
                    break;
                } else if (lcnt > 1) {
                    lcnt--;
                }
            }
        }
        if (start1 < n)
            root.left = str2tree(s.substring(start1 + 1, end1));
        // 3. get s2 if exists
        while (i < n && s.charAt(i) != '(') {
            i++;
        }
        if (i < n)
            root.right = str2tree(s.substring(i + 1, s.length() - 1));
        return root;
    }
}