/*
 * @lc app=leetcode id=206 lang=java
 *
 * [206] Reverse Linked List
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            // if length of list < 2, return directly
            return head;
        }

        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}

// class Solution {
// public ListNode reverseList(ListNode head) {
// if (head == null || head.next == null) {
// // if length of list < 2, return directly
// return head;
// }

// ListNode pre = new ListNode(0, head);

// ListNode cur = pre.next;
// ListNode next;

// while (cur.next != null) {
// next = cur.next;
// cur.next = next.next;
// next.next = pre.next;
// pre.next = next;
// }
// return pre.next;
// }
// }

// class Solution {
// public ListNode reverseList(ListNode head) {
// if (head == null || head.next == null) {
// // if length of list < 2, return directly
// return head;
// }

// // get old tail
// ListNode oldTail = head;
// ListNode p = head;
// while (p != null) {
// oldTail = p;
// p = p.next;
// }

// // oldTailNext: old tail's next
// ListNode oldTailNext = oldTail.next;
// // first: first node in this sublist
// ListNode first = head;

// while (oldTailNext != oldTail) {
// ListNode firstNext = first.next;
// // put first node after old tail
// first.next = oldTailNext;
// oldTailNext = first;

// // get new first
// first = firstNext;
// }

// return oldTail;
// }
// }

// class Solution {
// public ListNode reverseList(ListNode head) {
// if (head == null || head.next == null) {
// // if length of list < 2, return directly
// return head;
// }

// // get reverse subList strating from head next,
// // then head next will be the new tail of this sublist
// ListNode newHead = reverseList(head.next);
// // let new tail of sublist point to head
// head.next.next = head;
// // let new tail of list point to null
// head.next = null;

// return newHead;
// }
// }

// @lc code=end
