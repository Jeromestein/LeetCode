/*
 * @lc app=leetcode id=158 lang=java
 *
 * [158] Read N Characters Given Read4 II - Call multiple times
 */

// @lc code=start
/**
 * The read4 API is defined in the parent class Reader4. int read4(char[] buf4);
 */

public class Solution extends Reader4 {
    char[] prevBuf = new char[4];
    int prevSize = 0;
    int prevIndex = 0;

    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int counter = 0;

        while (counter < n) {
            if (prevIndex < prevSize) {
                buf[counter++] = prevBuf[prevIndex++];
            } else {
                prevIndex = 0;
                prevSize = read4(prevBuf);
                // System.out.println(prevSize);
                if (prevSize == 0) {
                    // no more data to consume from stream
                    break;
                }
            }
        }
        return counter;

    }
}
// @lc code=end
