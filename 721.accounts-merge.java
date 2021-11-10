import java.util.Map;

/*
 * @lc app=leetcode id=721 lang=java
 *
 * [721] Accounts Merge
 */

// @lc code=start

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        DSU dsu = new DSU();
        Map<String, String> emailToName = new HashMap();
        // map each unique email to a ID,
        // use ID to build Disjoint Set Union
        Map<String, Integer> emailToID = new HashMap();
        int id = 0;
        for (List<String> info : accounts) {
            String name = "";
            for (String str : info) {
                // first str is name
                if (name == "") {
                    name = str;
                    continue;
                }
                emailToName.put(str, name);
                if (!emailToID.containsKey(str)) {
                    emailToID.put(str, id++);
                }
                // union(foregoing emails, curr email)
                dsu.union(emailToID.get(info.get(1)), emailToID.get(str));
            }
        }

        Map<Integer, List<String>> ans = new HashMap();
        // each email DSU belongs to a unique user
        for (String email : emailToName.keySet()) {
            int index = dsu.find(emailToID.get(email));
            ans.computeIfAbsent(index, x -> new ArrayList()).add(email);
        }
        // sort emails and add the username
        for (List<String> component : ans.values()) {
            Collections.sort(component);
            component.add(0, emailToName.get(component.get(0)));
        }
        return new ArrayList(ans.values());
    }
}

class DSU {
    int[] root;

    public DSU() {
        root = new int[10000];
        for (int i = 0; i < 10000; ++i)
            root[i] = i;
    }

    public int find(int x) {
        if (root[x] != x)
            root[x] = find(root[x]);
        return root[x];
    }

    public void union(int x, int y) {
        root[find(x)] = find(y);
    }
}
// @lc code=end
