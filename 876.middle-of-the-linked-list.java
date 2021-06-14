/*
 * @lc app=leetcode id=876 lang=java
 *
 * [876] Middle of the Linked List
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode runner = head, walker = head;
        while (runner != null && runner.next != null) {
            walker = walker.next;
            runner = runner.next.next;
        }

        return walker;
    }
}
// @lc code=end
