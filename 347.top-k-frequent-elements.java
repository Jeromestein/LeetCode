import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 */

// @lc code=start
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int max = nums[0];
        int min = nums[0];
        for (int num : nums) {
            if (num > max) {
                max = num;
            } else if (num < min) {
                min = num;
            }
        }

        int[] count = new int[max - min + 1];
        for (int num : nums) {
            count[num - min]++;
        }

        // O(n*log(k))
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                if (pq.size() < k) {
                    pq.add(count[i]);
                } else {
                    // peek() get the front element in queue
                    if (pq.peek() < count[i]) {
                        pq.add(count[i]);
                        pq.remove();
                    }
                }
                // System.out.println(pq);
            }
        }

        int[] res = new int[k];
        int i = 0;
        // O(n)
        for (int ix = 0; ix < count.length; ix++) {
            if (count[ix] > 0 && count[ix] >= pq.peek()) {
                res[i] = ix + min;
                i++;
                if (i == k) {
                    return res;
                }
            }
        }

        // O(n * (2 + log(k)))
        return res;
    }
    // int[] unique;
    // Map<Integer, Integer> count;

    // public void swap(int a, int b) {
    // int tmp = unique[a];
    // unique[a] = unique[b];
    // unique[b] = tmp;
    // }

    // public int partition(int left, int right, int pivot_index) {
    // int pivot_frequency = count.get(unique[pivot_index]);
    // // 1. move pivot to end
    // swap(pivot_index, right);
    // int store_index = left;

    // // 2. move all less frequent elements to the left
    // for (int i = left; i <= right; i++) {
    // if (count.get(unique[i]) < pivot_frequency) {
    // swap(store_index, i);
    // store_index++;
    // }
    // }

    // // 3. move pivot to its final place
    // swap(store_index, right);

    // return store_index;
    // }

    // public void quickselect(int left, int right, int k_smallest) {
    // /*
    // * Sort a list within left..right till kth less frequent element takes its
    // * place.
    // */

    // // base case: the list contains only one element
    // if (left == right)
    // return;

    // // select a random pivot_index
    // Random random_num = new Random();
    // int pivot_index = left + random_num.nextInt(right - left);

    // // find the pivot position in a sorted list
    // pivot_index = partition(left, right, pivot_index);

    // // if the pivot is in its final sorted position
    // if (k_smallest == pivot_index) {
    // return;
    // } else if (k_smallest < pivot_index) {
    // // go left
    // quickselect(left, pivot_index - 1, k_smallest);
    // } else {
    // // go right
    // quickselect(pivot_index + 1, right, k_smallest);
    // }
    // }

    // public int[] topKFrequent(int[] nums, int k) {
    // // build hash map : character and how often it appears
    // count = new HashMap();
    // for (int num : nums) {
    // // Map.getOrDefault(Object key, V defaultValue);
    // // 如果在Map中存在key，则返回key所对应的的value。
    // // If Map has the key, then return value
    // // If no key, then return defaultValue
    // count.put(num, count.getOrDefault(num, 0) + 1);
    // }

    // // array of unique elements
    // int n = count.size();
    // unique = new int[n];
    // int i = 0;
    // // for (int num : count.keySet()) {
    // // unique[i] = num;
    // // i++;
    // // }
    // for (Map.Entry<Integer, Integer> num : count.entrySet()) {
    // unique[i++] = num.getKey();
    // }

    // // kth top frequent element is (n - k)th less frequent.
    // // Do a partial sort: from less frequent to the most frequent, till
    // // (n - k)th less frequent element takes its place (n - k) in a sorted array.
    // // All element on the left are less frequent.
    // // All the elements on the right are more frequent.
    // quickselect(0, n - 1, n - k);
    // // Return top k frequent elements
    // return Arrays.copyOfRange(unique, n - k, n);
    // }
}
// @lc code=end
