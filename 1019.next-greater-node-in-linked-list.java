import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode id=1019 lang=java
 *
 * [1019] Next Greater Node In Linked List
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */

class Solution {
    public int[] nextLargerNodes(ListNode head) {
        int n = 0;
        ListNode temp = head;

        while (temp != null) {
            temp = temp.next;
            n++;
        }

        // to store the values of the nodes
        int[] nums = new int[n];
        // to store next greater element of each node (default 0)
        int[] res = new int[n];
        Arrays.fill(res, 0);
        // to store the indexs
        Deque<Integer> stk = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            // get the current value and store it in array
            int currVal = head.val;
            nums[i] = currVal;

            // for all the recently seen elements smaller than curr
            while (!stk.isEmpty() && currVal > nums[stk.peek()]) {
                res[stk.pop()] = currVal;
            }

            stk.push(i);
            head = head.next;
        }

        return res;
    }
}
// @lc code=end
