/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int cin = 0;
        ListNode p1 = l1, p2 = l2, pre = null;
        int len1 = 0, len2 = 0;
        while (p1 != null && p2 != null) {
            int sum = p1.val + p2.val + cin;
            p1.val = p2.val = sum % 10;
            cin = sum / 10;

            pre = p1;
            p1 = p1.next;
            len1++;
            p2 = p2.next;
            len2++;
        }
        while (p1 != null) {
            int sum = p1.val + cin;
            p1.val = sum % 10;
            cin = sum / 10;

            pre = p1;
            p1 = p1.next;
            len1++;
        }
        while (p2 != null) {
            int sum = p2.val + cin;
            p2.val = sum % 10;
            cin = sum / 10;

            pre = p2;
            p2 = p2.next;
            len2++;
        }

        if (cin > 0) {
            // if len1 >= len2 pre is the pre of p1
            // else pre if pre the of p2
            pre.next = new ListNode(cin);
        }
        return len1 >= len2 ? l1 : l2;

    }
}
// @lc code=end
