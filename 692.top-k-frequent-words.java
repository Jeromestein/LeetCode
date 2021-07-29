import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jdk.internal.platform.Container;

/*
 * @lc app=leetcode id=692 lang=java
 *
 * [692] Top K Frequent Words
 */

// @lc code=start

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freqCNT = new HashMap<>();
        for (String word : words) {
            int freq = freqCNT.getOrDefault(word, 0) + 1;
            freqCNT.put(word, freq);
        }

        List<String> res = new ArrayList<>();
        for (String string : freqCNT.keySet()) {
            res.add(string);
        }

        Collections.sort(res, new Comparator<String>() {
            public int compare(String s1, String s2) {
                // a negative integer, zero, or a positive integer
                // as the first argument is less than, equal to, or greater than the second.
                int val1 = freqCNT.get(s1), val2 = freqCNT.get(s2);
                if (val1 != val2) {
                    return val2 - val1;
                } else {
                    // The result is a negative integer,
                    // if this String object lexicographically precedes the argument string.
                    // The result is a positive integer,
                    // if this String object lexicographically follows the argument string.
                    return s1.compareTo(s2);
                }
            }
        });

        return res.subList(0, k);
    }
}

// class Solution {
// public List<String> topKFrequent(String[] words, int k) {
// Map<String, Integer> cnt = new HashMap<String, Integer>();
// for (String word : words) {
// cnt.put(word, cnt.getOrDefault(word, 0) + 1);
// }
// PriorityQueue<Map.Entry<String, Integer>> pq = new
// PriorityQueue<Map.Entry<String, Integer>>(
// new Comparator<Map.Entry<String, Integer>>() {
// public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String,
// Integer> entry2) {
// int val1 = entry1.getValue(), val2 = entry2.getValue();
// String s1 = entry1.getKey(), s2 = entry2.getKey();
// return val1 == val2 ? s2.compareTo(s1) : val1 - val2;
// }
// });
// for (Map.Entry<String, Integer> entry : cnt.entrySet()) {
// pq.add(entry);
// if (pq.size() > k) {
// pq.poll();
// }
// }
// List<String> ret = new ArrayList<String>();
// while (!pq.isEmpty()) {
// ret.add(pq.poll().getKey());
// }
// Collections.reverse(ret);
// return ret;
// }
// }
// @lc code=end
