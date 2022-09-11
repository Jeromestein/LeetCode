/*
 * @lc app=leetcode id=1383 lang=java
 *
 * [1383] Maximum Performance of a Team
 */

// @lc code=start
class Solution {
    // greedy method:
    //
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int modulo = (int) Math.pow(10, 9) + 7;
        // candidates: (efficiency, speed)
        List<int[]> candidates = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            candidates.add(new int[] { efficiency[i], speed[i] });
        }
        // sort the members by their efficiencies descendingly
        // so when we walk throught it,
        // the currEfficiency will always be the min speed
        Collections.sort(candidates, (o1, o2) -> o2[0] - o1[0]);

        // create a heap to keep the top (k-1) speeds
        PriorityQueue<Integer> speedHeap = new PriorityQueue<>((o1, o2) -> o1 - o2);

        long speedSum = 0, perf = 0;
        for (int[] engineer : candidates) {
            Integer currEfficiency = engineer[0];
            Integer currSpeed = engineer[1];
            // maintain a heap for the fastest (k-1) speeds
            if (speedHeap.size() > k - 1) {
                speedSum -= speedHeap.poll();
            }
            speedHeap.add(currSpeed);

            // calculate the maximum performance with
            // the current member as the least efficient one in the team
            speedSum += currSpeed;
            perf = Math.max(perf, speedSum * currEfficiency);
        }
        return (int) (perf % modulo);
    }
}
// @lc code=end
