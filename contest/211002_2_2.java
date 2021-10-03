class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int leftSum = mean * (m + n);
        int left = 0, right = 0;

        for (int r : rolls) {
            leftSum -= r;

            if (r < mean)
                left++;
            if (r > mean)
                right++;
        }
        System.out.println(m + " " + n + " " + leftSum);

        if (leftSum > n * 6 || leftSum < n * 1)
            return new int[] {};

        int[] res = new int[n];
        int x = leftSum / n;
        for (int i = 0; i < n - 1; i++) {
            res[i] = x;
            leftSum -= x;
        }
        if (leftSum > 6) {
            res[n - 1] = 6;
            leftSum -= 6;
            for (int i = 0; i < leftSum; i++) {
                res[i]++;
            }
        } else {
            res[n - 1] = leftSum;
        }

        return res;
    }

}