import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode id=841 lang=java
 *
 * [841] Keys and Rooms
 */

// @lc code=start
// class Solution {
//     public boolean canVisitAllRooms(List<List<Integer>> rooms) {
//         int N = rooms.size();
//         boolean[] visited = new boolean[N];
//         Queue<Integer> q = new LinkedList<>();

//         visited[0] = true;
//         q.add(0);

//         while (!q.isEmpty()) {
//             int currRoom = q.poll();
//             for (Integer room : rooms.get(currRoom)) {
//                 if (!visited[room]) {
//                     visited[room] = true;
//                     q.add(room);
//                 }
//             }
//         }

//         boolean res = true;
//         for (int i = 0; i < N; i++) {
//             if (visited[i] == false) {
//                 res = false;
//                 break;
//             }
//         }

//         return res;
//     }
// }

class Solution {
    int N;
    boolean[] visited;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        N = rooms.size();
        visited = new boolean[N];

        dfs(rooms, 0);

        boolean res = true;
        for (int i = 0; i < N; i++) {
            if (visited[i] == false) {
                res = false;
                break;
            }
        }

        return res;
    }

    public void dfs(List<List<Integer>> rooms, int currRoom) {
        visited[currRoom] = true;
        for (Integer room : rooms.get(currRoom)) {
            if (!visited[room]) {
                visited[room] = true;
                dfs(rooms, room);
            }
        }
    }
}
// @lc code=end
