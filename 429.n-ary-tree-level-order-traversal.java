/*
 * @lc app=leetcode id=429 lang=java
 *
 * [429] N-ary Tree Level Order Traversal
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        // bfs
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int n = q.size();
            List<Integer> currLevel = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                Node curr = q.poll();
                currLevel.add(curr.val);

                for (Node child : curr.children) {
                    q.add(child);
                }
            }

            res.add(currLevel);
        }

        return res;
    }
}
// @lc code=end
