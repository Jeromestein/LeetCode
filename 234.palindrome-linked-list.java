import java.util.ArrayList;
import java.util.Stack;

/*
 * @lc app=leetcode id=234 lang=java
 *
 * [234] Palindrome Linked List
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    // public boolean isPalindrome(ListNode head) {
    // // 1. get the length
    // int length = 0;
    // for (ListNode p = head; p != null; p = p.next) {
    // length++;
    // }

    // Stack<Integer> stack = new Stack<>();
    // ListNode p = head;
    // for (int i = 0; i < length / 2; i++) {
    // stack.push(p.val);
    // p = p.next;
    // }

    // if (length % 2 == 1) {
    // p = p.next;
    // }

    // for (int i = (length + 1) / 2; i < length; i++) {
    // if (stack.peek() == p.val) {
    // stack.pop();
    // p = p.next;
    // } else {
    // return false;
    // }
    // }

    // if (stack.empty() == true) {
    // return true;
    // } else {
    // return false;
    // }
    // }

    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // odd nodes: let right half smaller
        if (fast != null) {
            slow = slow.next;
        }
        slow = reverse(slow);
        fast = head;

        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    // reverse the left half, a bit faster
    // public boolean isPalindrome(ListNode head) {
    // ListNode slow = head;
    // ListNode fast = head;
    // ListNode pre = null;
    // ListNode prepre = null;

    // while (fast != null && fast.next != null) {
    // pre = slow;
    // slow = slow.next;
    // fast = fast.next.next;
    // pre.next = prepre;
    // prepre = pre;
    // }

    // if (fast != null) {
    // slow = slow.next;
    // }

    // while (pre != null && slow != null) {
    // if (pre.val != slow.val) {
    // return false;
    // }
    // pre = pre.next;
    // slow = slow.next;
    // }
    // return true;
    // }

}
// @lc code=end
