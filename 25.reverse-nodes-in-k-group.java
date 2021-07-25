/*
 * @lc app=leetcode id=25 lang=java
 *
 * [25] Reverse Nodes in k-Group
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // create a new node before head
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode pre = hair;

        while (head != null) {
            ListNode tail = pre;
            // chechk if the length of list is less than k, find tail
            for (int i = 0; i < k; ++i) {
                tail = tail.next;
                if (tail == null) {
                    // if the length of list is less than k, return the list directly
                    return hair.next;
                }
            }
            ListNode[] reverse = myReverse(head, tail);
            head = reverse[0];
            tail = reverse[1];

            // let pre head point to new head
            // (not necessary to let new tail point to after tail,
            // we already did it in myReverse(). )
            pre.next = head;
            pre = tail;
            head = pre.next;
        }

        return hair.next;
    }

    public ListNode[] myReverse(ListNode oldHead, ListNode oldTail) {
        // oldTailNext: old tail's next
        ListNode oldTailNext = oldTail.next;
        // first: first node in this sublist
        ListNode first = oldHead;

        while (oldTailNext != oldTail) {
            ListNode firstNext = first.next;
            // put first node after old tail
            first.next = oldTailNext;
            oldTailNext = first;

            // get new first
            first = firstNext;
        }
        // new head is old tail, new tail is old head
        return new ListNode[] { oldTail, oldHead };
    }
}
// @lc code=end
