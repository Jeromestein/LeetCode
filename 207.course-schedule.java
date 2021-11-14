import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=207 lang=java
 *
 * [207] Course Schedule
 */

// @lc code=start

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // topological sorting
        // adjacent list, indegrees[e] = 0, cnt=0
        // q.add(e), check all the adjacent nodes, indegree[] - 1, cnt++
        int[] indegrees = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] pre : prerequisites) {
            map.computeIfAbsent(pre[1], k -> new ArrayList<>()).add(pre[0]);
            indegrees[pre[0]]++;
        }

        int cnt = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                q.add(i);
                cnt++;
            }
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int i : map.computeIfAbsent(node, k -> new ArrayList<>())) {
                indegrees[i]--;
                if (indegrees[i] == 0) {
                    q.add(i);
                    cnt++;
                }
            }
        }

        return cnt == numCourses;

    }
}

// @lc code=end
