/*
 * @lc app=leetcode id=82 lang=java
 *
 * [82] Remove Duplicates from Sorted List II
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            // if length of list < 2, return directly
            return head;
        }

        // create a node pre head point to head
        ListNode preHead = new ListNode(0, head);
        // start from pre head
        ListNode p = preHead;
        while (p.next != null && p.next.next != null) {
            // check if next and next next are equal
            if (p.next.val == p.next.next.val) {
                // if yes, then delete all duplicates after p equal to x
                deleteDuplicates(p, p.next.val);
            } else {
                // if not, then point moves to next
                p = p.next;
            }
        }

        return preHead.next;
    }

    public void deleteDuplicates(ListNode p, int val) {
        while (p.next != null && p.next.val == val) {
            // delete 'old' p.next
            p.next = p.next.next;
        }
    }
}
// @lc code=end
