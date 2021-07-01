import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=207 lang=java
 *
 * [207] Course Schedule
 */

// @lc code=start
class Solution {
    List<List<Integer>> edges;
    int[] visited;
    // if this course schedule is valid
    boolean valid = true;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<Integer>());
        }
        // prerequisites[i] = [ai, bi] ndicates that
        // you must take course bi first if you want to take course ai.
        // edges.get(bi) = ai
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
        }

        // default: all 0
        visited = new int[numCourses];
        for (int i = 0; i < numCourses && valid; ++i) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        return valid;
    }

    public void dfs(int u) {
        visited[u] = 1;
        for (int v : edges.get(u)) {
            if (visited[v] == 0) {
                // recursion
                dfs(v);
                if (!valid) {
                    return;
                }
            } else if (visited[v] == 1) {
                valid = false;
                return;
            }
        }
        visited[u] = 2;
    }
}
// @lc code=end
