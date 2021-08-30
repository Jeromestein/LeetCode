import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode id=1396 lang=java
 *
 * [1396] Design Underground System
 */

// @lc code=start

class UndergroundSystem {
    // <stationName, <id, t>>
    Map<String, Map<Integer, Integer>> stationIn;
    Map<String, Map<Integer, Integer>> stationOut;

    public UndergroundSystem() {
        stationIn = new HashMap<>();
        stationOut = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        stationIn.computeIfAbsent(stationName, k -> new HashMap<>()).put(id, t);
        System.out.println(stationIn);
    }

    public void checkOut(int id, String stationName, int t) {
        stationOut.computeIfAbsent(stationName, k -> new HashMap<>()).put(id, t);
        System.out.println(stationOut);
    }

    public double getAverageTime(String startStation, String endStation) {
        int totalEndTime = 0, totalStartTime = 0;
        double time = 0;
        int count = 0;
        Map<Integer, Integer> startMap = stationIn.get(startStation);
        Map<Integer, Integer> endMap = stationOut.get(endStation);

        for (int id : startMap.keySet()) {
            System.out.println(id);
            if (endMap.containsKey(id)) {
                time += endMap.get(id) - startMap.get(id);
                count++;
            }
        }

        return time / count;

    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t); obj.checkOut(id,stationName,t); double param_3
 * = obj.getAverageTime(startStation,endStation);
 */
// @lc code=end
