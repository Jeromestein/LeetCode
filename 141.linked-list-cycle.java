import java.util.HashMap;

/*
 * @lc app=leetcode id=141 lang=java
 *
 * [141] Linked List Cycle
 */

// @lc code=start
/**
 * Definition for singly-linked list. class ListNode { int val; ListNode next;
 * ListNode(int x) { val = x; next = null; } }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        HashMap<ListNode, Integer> map = new HashMap<>();
        while (head != null) {
            map.put(head, map.getOrDefault(head, 0) + 1);
            if (map.get(head) > 1) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
}
// @lc code=end
