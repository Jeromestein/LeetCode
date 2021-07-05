import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=1306 lang=java
 *
 * [1306] Jump Game III
 */

// @lc code=start
// class Solution {
//     boolean[] visited;

//     public boolean canReach(int[] arr, int start) {
//         int n = arr.length;
//         visited = new boolean[n];
//         Queue<Integer> q = new LinkedList<>();

//         visited[start] = true;
//         q.add(start);

//         while (!q.isEmpty()) {
//             int currIdx = q.poll();
//             // check if you can reach to any index with value 0
//             if (arr[currIdx] == 0) {
//                 return true;
//             }

//             int lNextIdx = currIdx - arr[currIdx];
//             int rNextIdx = currIdx + arr[currIdx];
//             if (0 <= lNextIdx && lNextIdx < n && !visited[lNextIdx]) {
//                 visited[lNextIdx] = true;
//                 q.add(lNextIdx);
//             }
//             if (0 <= rNextIdx && rNextIdx < n && !visited[rNextIdx]) {
//                 visited[rNextIdx] = true;
//                 q.add(rNextIdx);
//             }
//         }
//         return false;
//     }
// }

class Solution {
    int n;
    boolean[] visited;

    public boolean canReach(int[] arr, int start) {
        n = arr.length;
        visited = new boolean[n];

        return dfs(arr, start);
    }

    public boolean dfs(int[] arr, int currIdx) {
        if (arr[currIdx] == 0) {
            return true;
        }

        int lNextIdx = currIdx - arr[currIdx];
        int rNextIdx = currIdx + arr[currIdx];
        if (0 <= lNextIdx && lNextIdx < n && !visited[lNextIdx]) {
            visited[lNextIdx] = true;
            if (dfs(arr, lNextIdx))
                return true;
        }
        if (0 <= rNextIdx && rNextIdx < n && !visited[rNextIdx]) {
            visited[rNextIdx] = true;
            if (dfs(arr, rNextIdx))
                return true;
        }
        return false;
    }
}
// @lc code=end
