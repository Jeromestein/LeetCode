import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode id=210 lang=java
 *
 * [210] Course Schedule II
 */

// @lc code=start
class Solution {
    // ArrayList<Integer> res;
    int[] res;
    int index;

    List<List<Integer>> adjList;
    // 0: unvisited
    // 1: visiting
    // 2: visited
    int[] visited;
    // If it is impossible to finish all courses, return an empty array.
    boolean valid = true;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // initialize the adjacent list
        adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<Integer>());
        }

        for (int[] p : prerequisites) {
            adjList.get(p[1]).add(p[0]);
        }

        // res = new ArrayList<>();
        res = new int[numCourses];
        index = numCourses - 1;

        visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        if (valid) {
            // return res.stream().mapToInt(Integer::valueOf).toArray();
            return res;
        } else {
            return new int[] {};
        }
    }

    public void dfs(int u) {
        visited[u] = 1;

        for (int v : adjList.get(u)) {
            if (visited[v] == 0) {
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
        // insert to the head to implement reversal
        // res.add(0, u);
        res[index--] = u;
    }
}
// @lc code=end
