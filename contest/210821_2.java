import java.util.HashSet;
import java.util.Set;

class Solution {
    public String findDifferentBinaryString(String[] nums) {
        // 1 <= n <= 16
        // 2^n > n
        // max= 2^16 = 65536
        int n = nums.length;
        int max = (int) Math.pow(2, n);

        Set<Integer> set = new HashSet<>();
        for (String string : nums) {
            int num = Integer.parseInt(string, 2);
            set.add(num);
        }

        for (int i = 0; i <= max; i++) {
            if (!set.contains(i)) {
                // from int to n bits binary
                StringBuilder res = new StringBuilder();

                while (i > 0) {
                    int currDigit = i % 2;
                    res.insert(0, currDigit);
                    i /= 2;
                }

                for (int j = res.length(); j < n; j++) {
                    res.insert(0, 0);
                }

                return res.toString();
            }
        }

        return "";
    }
}