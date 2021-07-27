/*
 * @lc app=leetcode id=445 lang=java
 *
 * [445] Add Two Numbers II
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 1. reverse 2 lists
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        // 2. add 2 numbers like before
        ListNode preHead = new ListNode(0);
        ListNode node = preHead;
        int sum = 0, cin = 0;
        while (l1 != null && l2 != null) {
            sum = cin + l1.val + l2.val;
            cin = sum / 10;
            node.next = new ListNode(sum % 10);
            node = node.next;

            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            sum = cin + l1.val;
            cin = sum / 10;
            node.next = new ListNode(sum % 10);
            node = node.next;

            l1 = l1.next;
        }
        while (l2 != null) {
            sum = cin + l2.val;
            cin = sum / 10;
            node.next = new ListNode(sum % 10);
            node = node.next;

            l2 = l2.next;
        }
        if (cin > 0) {
            node.next = new ListNode(cin);
            node = node.next;
        }
        node.next = null;
        // 3. reverse the new list
        return reverseList(preHead.next);
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode preHead = new ListNode(0, head);
        ListNode pre = preHead, curr = head, next = head.next;
        while (curr.next != null) {
            next = curr.next;
            curr.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }

        return preHead.next;
    }
}
// @lc code=end
