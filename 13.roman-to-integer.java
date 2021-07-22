import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=13 lang=java
 *
 * [13] Roman to Integer
 */

// @lc code=start
class Solution {
    // Map<Character, Integer> roman2Int = new HashMap<Character, Integer>() {
    // {
    // put('I', 1);
    // put('V', 5);
    // put('X', 10);
    // put('L', 50);
    // put('C', 100);
    // put('D', 500);
    // put('M', 1000);
    // }
    // };

    public int romanToInt(String s) {

        int sum = 0, num = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            // num = roman2Int.get(s.charAt(i));
            switch (s.charAt(i)) {
            case 'I':
                num = 1;
                break;
            case 'V':
                num = 5;
                break;
            case 'X':
                num = 10;
                break;
            case 'L':
                num = 50;
                break;
            case 'C':
                num = 100;
                break;
            case 'D':
                num = 500;
                break;
            case 'M':
                num = 1000;
                break;
            }
            if (num * 4 < sum) {
                sum -= num;
            } else {
                sum += num;
            }
        }
        return sum;
    }
}
// @lc code=end
