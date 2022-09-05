/*
 * @lc app=leetcode id=472 lang=java
 *
 * [472] Concatenated Words
 */

// @lc code=start
class Solution {
    // use trie to check concatenated words
    Trie trie = new Trie();

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<String>();
        // 1. for convience, sort it length-ascendingly
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        // 2. walk thourgh all the words, recursively check if it is concatenated
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            boolean[] visited = new boolean[word.length()];
            if (isConcatenated(word, 0, visited)) {
                res.add(word);
            } else {
                insert2Trie(word);
            }
        }
        return res;
    }

    public boolean isConcatenated(String word, int start, boolean[] visited) {
        if (word.length() == start) {
            return true;
        }
        if (visited[start]) {
            return false;
        }

        visited[start] = true;
        Trie node = trie;
        for (int i = start; i < word.length(); i++) {
            char currChar = word.charAt(i);
            node = node.children[currChar - 'a'];

            if (node == null) {
                return false;
            }
            if (node.isEnd) {
                if (isConcatenated(word, i + 1, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    // insert word to Trie
    public void insert2Trie(String word) {
        Trie node = trie;
        for (int i = 0; i < word.length(); i++) {
            char currChar = word.charAt(i);

            if (node.children[currChar - 'a'] == null) {
                node.children[currChar - 'a'] = new Trie();
            }
            node = node.children[currChar - 'a'];
        }
        node.isEnd = true;
    }
}

class Trie {
    Trie[] children;
    boolean isEnd;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }
}

// @lc code=end
