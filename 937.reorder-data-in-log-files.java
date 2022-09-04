/*
 * @lc app=leetcode id=937 lang=java
 *
 * [937] Reorder Data in Log Files
 */

// @lc code=start
class Solution {
    private static String LETTER_REGEX = "[a-z]+";
    private static String DIGIT_REGEX = "[0-9]+";

    public String[] reorderLogFiles(String[] logs) {
        // 1. judge letter/digit logs
        // [identifier, contents]
        List<List<String>> letterLogs = new ArrayList<>();
        List<String> digitLogs = new ArrayList<>();

        for (String log : logs) {
            String[] str = log.split(" ", 2);
            String identifier = str[0];
            String contents = str[1];
            // except the identifier
            String[] words = contents.split(" ");
            boolean isLetterLogs = true, isDigitLogs = true;
            for (String word : words) {
                if (!word.matches(LETTER_REGEX))
                    isLetterLogs = false;
                if (!word.matches(DIGIT_REGEX))
                    isDigitLogs = false;
            }

            if (isLetterLogs) {
                letterLogs.add(new ArrayList<>());
                int n = letterLogs.size();
                letterLogs.get(n - 1).add(identifier);
                letterLogs.get(n - 1).add(contents);
            }

            if (isDigitLogs)
                digitLogs.add(log);
        }

        // 2. reorder: letter logs first, lexicographically; digti logs keep relative
        // order
        // defaultly lexicographical order
        Collections.sort(letterLogs, new Comparator<List<String>>() {
            public int compare(List<String> l1, List<String> l2) {
                if (l1.get(1).compareTo(l2.get(1)) != 0)
                    return l1.get(1).compareTo(l2.get(1));
                else
                    return l1.get(0).compareTo(l2.get(0));
            }
        });

        String[] res = new String[letterLogs.size() + digitLogs.size()];
        int i;
        for (i = 0; i < letterLogs.size(); i++) {
            res[i] = letterLogs.get(i).get(0) + " " + letterLogs.get(i).get(1);
        }
        for (int j = 0; j < digitLogs.size(); j++) {
            res[i + j] = digitLogs.get(j);
        }

        return res;
    }
}
// @lc code=end
