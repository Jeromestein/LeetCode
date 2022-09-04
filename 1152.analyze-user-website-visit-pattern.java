/*
 * @lc app=leetcode id=1152 lang=java
 *
 * [1152] Analyze User Website Visit Pattern
 */

// @lc code=start
class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        int n = timestamp.length;
        // 1. Sort tuple list by time, cannot use map, because web will be duplicated
        // tuple: [username, timestamp, website]
        List<List<String>> tuple = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tuple.add(new ArrayList<>());
            tuple.get(i).add(username[i]);
            // String list
            tuple.get(i).add("" + timestamp[i]);
            tuple.get(i).add(website[i]);
        }
        tuple.sort((a, b) -> Integer.parseInt(a.get(1)) - Integer.parseInt(b.get(1)));

        // 2. add each person visited list;
        Map<String, List<String>> user2websites = new HashMap<>();// (name, list<web>)
        for (int i = 0; i < n; i++) {
            String name = tuple.get(i).get(0), web = tuple.get(i).get(2);
            user2websites.computeIfAbsent(name, k -> new ArrayList<>());
            user2websites.get(name).add(web);
        }

        // 3. find each user list and build all 3-subsequences and count by map, and get
        // maxCount;
        Map<String, Integer> sequence = new HashMap<>();// (sequence, count)
        int maxCount = 0;
        String maxPattern = "";
        for (List<String> websites : user2websites.values()) {
            if (websites.size() < 3)
                continue;
            // build users' all 3-sequences, use set in case duplicated 3-sequences
            Set<String> patterns = getPattern(websites);
            for (String p : patterns) {
                int cnt = sequence.getOrDefault(p, 0);
                sequence.put(p, ++cnt);
                if (cnt > maxCount) {
                    maxCount = cnt;
                    maxPattern = p;
                } else if (cnt == maxCount && p.compareTo(maxPattern) < 0)
                    maxPattern = p;
            }
        }

        String[] strs = maxPattern.split(",");
        List<String> res = new ArrayList<>();
        for (String s : strs)
            res.add(s);
        return res;
    }

    public Set<String> getPattern(List<String> list) {
        int n = list.size();
        Set<String> res = new HashSet<>();
        // !!!!
        // <asd, aqwe, qweg, asd> could have 4 patterns!!!!
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    res.add(list.get(i) + "," + list.get(j) + "," + list.get(k));
                }
            }
        }
        return res;
    }
}
// @lc code=end
