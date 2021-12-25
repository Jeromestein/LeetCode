/*
 * @lc app=leetcode id=797 lang=java
 *
 * [797] All Paths From Source to Target
 */

// @lc code=start
class Solution {
    List<List<Integer>> res;
    int n;
    int[][] graph;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        this.graph = graph;
        this.n = graph.length;
        this.res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        backtracing(0, path);

        return this.res;
    }

    public void backtracing(int curr, List<Integer> path) {
        if (curr == n - 1) {
            this.res.add(new ArrayList<>(path));
            return;
        }

        for (int next : graph[curr]) {
            path.add(next);
            backtracing(next, path);
            path.remove(path.size() - 1);
        }

    }
}
// @lc code=end
