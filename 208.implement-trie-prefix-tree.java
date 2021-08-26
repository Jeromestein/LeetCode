import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=208 lang=java
 *
 * [208] Implement Trie (Prefix Tree)
 */

// @lc code=start
class Trie {
    Set<String> set;

    /** Initialize your data structure here. */
    public Trie() {
        set = new HashSet<>();

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        set.add(word);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return set.contains(word);
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        for (String string : set) {
            if (string.indexOf(prefix) == 0) {
                return true;
            }
        }

        return false;
    }
}

/**
 * Your Trie object will be instantiated and called as such: Trie obj = new
 * Trie(); obj.insert(word); boolean param_2 = obj.search(word); boolean param_3
 * = obj.startsWith(prefix);
 */
// @lc code=end
