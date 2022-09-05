/*
 * @lc app=leetcode id=1268 lang=java
 *
 * [1268] Search Suggestions System
 */

// @lc code=start
class Solution {
    Trie trie = new Trie();

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        // 2. insert all the products to trie
        for (String p : products) {
            insert2Trie(p);
        }

        // 3. walk through all the letters in searchWord, create suggested products
        // lists
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < searchWord.length(); i++) {
            String currInput = searchWord.substring(0, i + 1);
            res.add(startWith(currInput));
        }

        return res;
    }

    private void insert2Trie(String word) {
        Trie node = trie;

        for (int i = 0; i < word.length(); i++) {
            char currChar = word.charAt(i);

            if (node.children[currChar - 'a'] == null) {
                node.children[currChar - 'a'] = new Trie();
            }
            node = node.children[currChar - 'a'];

            node.queue.add(word);
            if (node.queue.size() > 3) {
                node.queue.poll();
            }

        }
        node.isEnd = true;
    }

    private List<String> startWith(String prefix) {
        List<String> products = new ArrayList<>();
        // get node
        Trie node = trie;
        for (int i = 0; i < prefix.length(); i++) {
            char currChar = prefix.charAt(i);

            if (node.children[currChar - 'a'] != null) {
                node = node.children[currChar - 'a'];
            } else {
                return products;
            }
        }

        while (!node.queue.isEmpty()) {
            products.add(node.queue.poll());
        }
        Collections.reverse(products);
        return products;
    }
}

class Trie {
    Trie[] children;
    boolean isEnd;
    PriorityQueue<String> queue;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
        queue = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));
    }
}
// @lc code=end
