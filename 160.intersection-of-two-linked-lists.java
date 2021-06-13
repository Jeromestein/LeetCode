/*
 * @lc app=leetcode id=160 lang=java
 *
 * [160] Intersection of Two Linked Lists
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; next = null; } }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        // get the length of A and B
        int lengthA = 0, lengthB = 0;
        for (ListNode i = headA; i != null; i = i.next)
            lengthA++;
        for (ListNode i = headB; i != null; i = i.next)
            lengthB++;

        // get the difference value of their lengths
        // and set 2 pointers
        ListNode a = headA, b = headB;
        while (lengthA > lengthB) {
            a = a.next;
            lengthA--;
        }
        while (lengthB > lengthA) {
            b = b.next;
            lengthB--;
        }

        // find the intersection
        while (a != b) {
            a = a.next;
            b = b.next;
        }

        return a;

        // // a short code
        // // but when there is no intersection,
        // // the code's runtime will be too long
        // ListNode a = headA, b = headB;
        // while (a != b) {
        // a = (a == null) ? headA : a.next;
        // b = (b == null) ? headB : b.next;
        // }
        // return a;
    }
}
// @lc code=end
