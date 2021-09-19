import java.util.HashMap;
import java.util.Map;

class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {
        // from 1 to n in the direction you are going
        // <end, <start, earn>>
        Map<Integer, Map<Integer, Integer>> ridemap = new HashMap<>();
        for (int[] r : rides) {
            int end = r[1], start = r[0];
            Map<Integer, Integer> start2earn = ridemap.getOrDefault(end, new HashMap<>());
            // get the max earn
            int earn = Math.max(r[1] - r[0] + r[2], start2earn.getOrDefault(start, 0));

            start2earn.put(start, earn);
            ridemap.put(end, start2earn);
        }

        long[] dp = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            // default get the dp[i-1]
            dp[i] = dp[i - 1];

            Map<Integer, Integer> start2earn = ridemap.getOrDefault(i, new HashMap<>());
            for (int start : start2earn.keySet()) {
                int earn = start2earn.get(start);
                dp[i] = Math.max(dp[i], dp[start] + earn);
            }

        }

        // for(long x:dp){
        // System.out.println(x);
        // }

        return dp[n];
    }
}