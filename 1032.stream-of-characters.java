/*
 * @lc app=leetcode id=1032 lang=java
 *
 * [1032] Stream of Characters
 */

// @lc code=start

class StreamChecker {
    TrieNode root;
    List<Character> stream;

    class TrieNode {
        boolean isWord;
        TrieNode[] next;

        TrieNode() {
            isWord = false;
            next = new TrieNode[26];
        }
    }

    public StreamChecker(String[] words) {
        root = new TrieNode();
        buildTrie(words);
        stream = new ArrayList<>();
    }

    void buildTrie(String[] words) {
        for (String s : words) {
            insert(s);
        }
    }

    void insert(String s) {
        TrieNode p = root;
        // build trie but in reversed order for each word
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (p.next[c - 'a'] == null) {
                p.next[c - 'a'] = new TrieNode();
            }
            p = p.next[c - 'a'];
        }
        p.isWord = true;
    }

    public boolean query(char letter) {
        stream.add(letter);
        TrieNode p = root;
        for (int i = stream.size() - 1; i >= 0; i--) {
            char c = stream.get(i);
            // return false immediately when we can't find c in Trie
            if (p.next[c - 'a'] == null)
                return false;
            // find a word
            if (p.next[c - 'a'].isWord)
                return true;

            p = p.next[c - 'a'];
        }
        return false;
    }

}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words); boolean param_1 =
 * obj.query(letter);
 */
// @lc code=end
