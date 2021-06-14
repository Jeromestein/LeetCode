/*
 * @lc app=leetcode id=142 lang=java
 *
 * [142] Linked List Cycle II
 */

// @lc code=start
/**
 * Definition for singly-linked list. class ListNode { int val; ListNode next;
 * ListNode(int x) { val = x; next = null; } }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null)
            return null;
        // 1. is there a cycle?
        boolean flag = false;
        ListNode runner = head, walker = head, end = head;
        while (runner.next != null && runner.next.next != null) {
            runner = runner.next.next;
            walker = walker.next;
            if (runner == walker) {
                flag = true;
                end = runner;
                // System.out.println(end.val);
                break;
            }
        }
        if (flag == false)
            return null;

        // 2. break cycle at end node
        // consider it as find the intersection of two lists

        // 2.1 get the lengths
        ListNode head1 = head, head2 = end.next;
        int len1 = 0, len2 = 0;
        while (head1 != end) {
            len1++;
            head1 = head1.next;
        }
        while (head2 != end) {
            len2++;
            head2 = head2.next;
        }

        // 2.2 set the start node
        head1 = head;
        head2 = end.next;
        while (len1 > len2) {
            len1--;
            head1 = head1.next;
        }
        while (len2 > len1) {
            len2--;
            head2 = head2.next;
        }

        // 2.3 find the intersection
        while (head1 != head2) {
            head1 = head1.next;
            head2 = head2.next;
        }
        return head1;
    }
}
// @lc code=end
