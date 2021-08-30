import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/*
 * @lc app=leetcode id=981 lang=java
 *
 * [981] Time Based Key-Value Store
 */

// @lc code=start

class TimeMap {

    /** Initialize your data structure here. */
    HashMap<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        map = new HashMap();
    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new TreeMap()).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        // If there are no values, it returns "".
        if (!map.containsKey(key)) {
            return "";
        }
        // If there are multiple such values,
        // it returns the value associated with the largest timestamp_prev.
        Integer time = map.get(key).floorKey(timestamp);
        if (time == null) {
            return "";
        }

        return map.get(key).get(time);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such: TimeMap obj =
 * new TimeMap(); obj.set(key,value,timestamp); String param_2 =
 * obj.get(key,timestamp);
 */
// @lc code=end
