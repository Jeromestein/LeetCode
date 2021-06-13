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
        for (ListNode i = headA; i != null; i = i.next) {
            lengthA++;
        }
        for (ListNode i = headB; i != null; i = i.next) {
            lengthB++;
        }

        // get the difference value of their lengths
        // and set 2 pointers
        ListNode a = headA, b = headB;
        if (lengthA > lengthB) {
            int temp = lengthA - lengthB;
            while (temp > 0) {
                a = a.next;
                temp--;
            }
        } else {
            int temp = lengthB - lengthA;
            while (temp > 0) {
                b = b.next;
                temp--;
            }
        }

        while (a != null && b != null) {
            if (a == b) {
                return a;
            }

            a = a.next;
            b = b.next;
        }

        return null;
    }
}
// @lc code=end
