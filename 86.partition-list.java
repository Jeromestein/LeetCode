/*
 * @lc app=leetcode id=86 lang=java
 *
 * [86] Partition List
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode p = head;
        ListNode small = new ListNode(0), large = new ListNode(0);
        ListNode smallHead = small, largeHead = large;

        while (p != null) {
            if (p.val < x) {
                small.next = p;
                small = small.next;
            } else {
                large.next = p;
                large = large.next;
            }

            p = p.next;
        }

        large.next = null;
        small.next = largeHead.next;

        return smallHead.next;
    }
}
// @lc code=end
