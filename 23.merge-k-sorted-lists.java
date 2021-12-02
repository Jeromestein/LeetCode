/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */

class Solution {
    // Divide and Conquer, recursion
    // public ListNode mergeKLists(ListNode[] lists) {
    // return merge(lists, 0, lists.length - 1);
    // }

    // public ListNode merge(ListNode[] lists, int l, int r) {
    // if (l == r) {
    // return lists[l];
    // }
    // if (l > r) {
    // return null;
    // }
    // int mid = (l + r) >> 1;
    // return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
    // }

    // Divide and Conquer, iteration
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        int interval = 1;
        while (interval < lists.length) {
            for (int i = 0; i < lists.length - interval; i = i + 2 * interval) {
                lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
            }
            interval *= 2;
        }
        return lists[0];
    }

    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a != null ? a : b;
        }
        ListNode preHead = new ListNode(0);
        ListNode tail = preHead, aPtr = a, bPtr = b;
        while (aPtr != null && bPtr != null) {
            if (aPtr.val < bPtr.val) {
                tail.next = aPtr;
                aPtr = aPtr.next;
            } else {
                tail.next = bPtr;
                bPtr = bPtr.next;
            }
            tail = tail.next;
        }
        tail.next = aPtr != null ? aPtr : bPtr;
        return preHead.next;
    }
}

// @lc code=end
