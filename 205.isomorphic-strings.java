import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode id=205 lang=java
 *
 * [205] Isomorphic Strings
 */

// @lc code=start

// class Solution {
//     public boolean isIsomorphic(String s, String t) {
//         /**
//          * isomorphic:
//          * 
//          * All occurrences of a character must be replaced with another character while
//          * preserving the order of characters.
//          * 
//          * No two characters may map to the same character, but a character may map to
//          * itself.
//          */

//         // t.length == s.length
//         int n = s.length();
//         Map<Character, Character> s2t = new HashMap<>();
//         Map<Character, Character> t2s = new HashMap<>();
//         Set<Character> sSet = new HashSet<>();
//         Set<Character> tSet = new HashSet<>();
//         for (int i = 0; i < n; i++) {
//             char sChar = s.charAt(i), tChar = t.charAt(i);
//             if (s2t.containsKey(sChar)) {
//                 if (s2t.get(sChar) != tChar) {
//                     return false;
//                 }
//             } else {
//                 s2t.put(sChar, tChar);

//                 sSet.add(sChar);
//                 tSet.add(tChar);
//                 if (sSet.size() != tSet.size()) {
//                     return false;
//                 }
//             }
//         }

//         return true;
//     }
// }

class Solution {
    public boolean isIsomorphic(String s, String t) {
        int length = s.length();

        char[] sm = new char[256];
        char[] tm = new char[256];

        for (int i = 0; i < length; i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);

            if (sm[sc] == 0 && tm[tc] == 0) {
                sm[sc] = tc;
                tm[tc] = sc;
            } else {
                if (sm[sc] != tc || tm[tc] != sc) {
                    return false;
                }
            }

        }

        return true;
    }
}
// @lc code=end
