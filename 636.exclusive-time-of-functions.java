/*
 * @lc app=leetcode id=636 lang=java
 *
 * [636] Exclusive Time of Functions
 */

// @lc code=start

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        int prevTime = 0;
        for (String log : logs) {
            String[] parts = log.split(":");
            if (!stack.isEmpty()) {
                res[stack.peek()] += Integer.parseInt(parts[2]) - prevTime;
            }
            prevTime = Integer.parseInt(parts[2]);
            if ("start".equals(parts[1])) {
                stack.push(Integer.parseInt(parts[0]));
            } else if ("end".equals(parts[1])) {
                // end:x means ending at the begin of x+1
                // so it should actually be x+1
                res[stack.pop()]++;
                prevTime++;
            }
        }
        return res;
    }
}

// @lc code=end
