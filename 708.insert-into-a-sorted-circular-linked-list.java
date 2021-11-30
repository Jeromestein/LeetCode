/*
 * @lc app=leetcode id=708 lang=java
 *
 * [708] Insert into a Sorted Circular Linked List
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        Node insert = new Node(insertVal);
        if (head == null) {
            insert.next = insert;
            return insert;
        }

        Node pre = head;
        Node curr = head.next;
        boolean toInsert = false;

        while (curr != head) {
            if (pre.val <= insertVal && insertVal <= curr.val) {
                // Case 1).
                pre.next = insert;
                insert.next = curr;
                return head;
            } else if (pre.val > curr.val && (insertVal >= pre.val || insertVal <= curr.val)) {
                // Case 2).
                pre.next = insert;
                insert.next = curr;
                return head;
            }

            pre = pre.next;
            curr = curr.next;
        }

        // Case 3).
        pre.next = insert;
        insert.next = curr;
        return head;
    }
}
// @lc code=end
