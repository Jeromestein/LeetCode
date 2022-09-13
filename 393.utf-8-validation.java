/*
 * @lc app=leetcode id=393 lang=java
 *
 * [393] UTF-8 Validation
 */

// @lc code=start
class Solution {
    public boolean validUtf8(int[] data) {
        // Number of bytes in the current UTF-8 character
        int numBytes = 0;

        // Masks to check two most significant bits in a byte.
        // check start with 10
        int mask1 = 1 << 7;
        int mask2 = 1 << 6;

        // For each integer in the data array.
        for (int i = 0; i < data.length; i++) {
            // If this is the case then we are to start processing a new UTF-8 character.
            if (numBytes == 0) {
                int mask = 1 << 7;
                // first n 1-bits
                while ((mask & data[i]) != 0) {
                    numBytes += 1;
                    mask = mask >> 1;
                }

                // 1 byte characters
                if (numBytes == 0) {
                    continue;
                }

                // Invalid scenarios according to the rules of the problem.
                if (numBytes > 4 || numBytes == 1) {
                    return false;
                }
            } else {
                // start with 10
                if (!((data[i] & mask1) != 0 && (mask2 & data[i]) == 0)) {
                    return false;
                }
            }

            // We reduce the number of bytes to process by 1 after each integer.
            numBytes -= 1;
        }

        // This is for the case where we might not have the complete data for
        // a particular UTF-8 character.
        return numBytes == 0;
    }
}

// class Solution {
// public boolean validUtf8(int[] data) {
// // 1. start with 0, considered as 1 byte UTF8
// // 2. find 10 to validate the format
// int pre = 0, len = 0;
// for (int i = 0; i < data.length; i++) {
// String b = String.format("%8s", Integer.toBinaryString(data[i])).replaceAll("
// ", "0");
// int curr = b.indexOf("0");
// // 1 byte: curr==0
// // 2-4 byte: 2<=first<=4
// if (curr == 0 && len == 0) {
// pre = curr;
// } else if (curr >= 2 && curr <= 4 && len == 0) {
// pre = curr;
// len = curr - 1;
// } else if (curr == 1 && len > 0) {
// pre = curr;
// len--;
// } else {
// return false;
// }

// }

// return pre == 0 || pre == 1 & len == 0;
// }
// }
// @lc code=end
