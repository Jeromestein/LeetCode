/*
 * @lc app=leetcode id=937 lang=java
 *
 * [937] Reorder Data in Log Files
 */

// @lc code=start
class Solution {
    public String[] reorderLogFiles(String[] logs) {

        Comparator<String> myComp = new Comparator<String>() {
            public int compare(String log1, String log2) {
                // split each log into two parts: [identifier, contents]
                String[] split1 = log1.split(" ", 2);
                String[] split2 = log2.split(" ", 2);

                boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

                // case 1: both logs are letter-logs
                if (!isDigit1 && !isDigit2) {
                    // first compare the content
                    int contentCmp = split1[1].compareTo(split2[1]);
                    if (contentCmp != 0)
                        return contentCmp;
                    else
                        // logs of same content, compare the identifiers
                        return split1[0].compareTo(split2[0]);
                }

                // case 2: one of logs is digit-log
                if (!isDigit1 && isDigit2)
                    // the letter-log comes before digit-logs
                    return -1;
                else if (isDigit1 && !isDigit2)
                    return 1;
                else
                    // case 3). both logs are digit-log
                    // keep relative order
                    return 0;
            }
        };

        Arrays.sort(logs, myComp);
        return logs;
    }
}
// @lc code=end
