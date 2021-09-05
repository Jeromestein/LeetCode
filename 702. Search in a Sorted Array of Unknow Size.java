/**
 * // This is ArrayReader's API interface. // You should not implement it, or
 * speculate about its implementation interface ArrayReader { public int get(int
 * index) {} }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        // 1. get length
        // 1 <= secret.length <= 10^4
        int left = 1, right = 10000;
        while (left < right) {
            int mid = (left + right) / 2;
            if (reader.get(mid) == Integer.MAX_VALUE) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        int len = left;

        left = 0;
        right = len - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (reader.get(mid) == target) {
                return mid;
            } else if (reader.get(mid) < target) {
                left = mid + 1;
            } else if (reader.get(mid) > target) {
                right = mid - 1;
            }
        }

        return -1;
    }
}