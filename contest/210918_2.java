class Solution {
    public int[] findOriginalArray(int[] changed) {

        int n = changed.length;

        Map<Integer, Integer> map1 = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        Arrays.sort(changed);
        for (int i = 0; i < n; i++) {
            int val = map1.getOrDefault(changed[i], 0);
            map1.put(changed[i], val + 1);
        }
        if (map1.containsKey(0) && map1.get(0) % 2 != 0 || n % 2 != 0)
            return new int[] {};

        int cnt = 0;
        int[] res = new int[n / 2];
        for (int i = 0; i < n; i++) {
            if (cnt < n / 2 && map1.getOrDefault(changed[i], 0) > 0 && map1.getOrDefault(2 * changed[i], 0) > 0) {
                res[cnt] = changed[i];
                cnt++;

                map1.put(changed[i], map1.get(changed[i]) - 1);
                map1.put(2 * changed[i], map1.get(2 * changed[i]) - 1);
            }
        }

        if (cnt != n / 2)
            return new int[] {};
        else {
            return res;
        }
    }
}