import java.util.Collections;
import java.util.Deque;

/*
 * @lc app=leetcode id=394 lang=java
 *
 * [394] Decode String
 */

// @lc code=start

class Solution {
    int ptr;

    public String decodeString(String s) {
        Deque<String> stk = new LinkedList<String>();
        ptr = 0;

        while (ptr < s.length()) {
            char currDigit = s.charAt(ptr);
            // s consists of lowercase English letters, digits, and square brackets '[' &
            // ']'.
            if (Character.isDigit(currDigit)) {
                // get multi digits number in the type of string
                String num = getNum(s);
                stk.addLast(num);
            } else if (Character.isLetter(currDigit) || currDigit == '[') {
                // get a letter in the type of string
                stk.addLast(String.valueOf(s.charAt(ptr)));
                ptr++;
            } else if (currDigit == ']') {
                // skip ']'
                ptr++;

                // get the encoded_string between '[' and ']'
                Deque<String> sub = new LinkedList<String>();
                while (!"[".equals(stk.peekLast())) {
                    sub.addFirst(stk.removeLast());
                }

                // pop the '['
                stk.removeLast();

                int k = Integer.parseInt(stk.removeLast());
                StringBuilder t = new StringBuilder();
                String encoded_string = getString(sub);

                // repeat the encoded_string based on k
                while (k-- > 0) {
                    t.append(encoded_string);
                }

                stk.addLast(t.toString());
            }
        }

        return getString(stk);
    }

    // get multi digits number
    public String getNum(String s) {
        StringBuilder res = new StringBuilder();
        while (Character.isDigit(s.charAt(ptr))) {
            res.append(s.charAt(ptr));
            ptr++;
        }
        return res.toString();
    }

    public String getString(Deque<String> v) {
        StringBuilder res = new StringBuilder();
        for (String s : v) {
            res.append(s);
        }
        return res.toString();
    }
}

// @lc code=end
