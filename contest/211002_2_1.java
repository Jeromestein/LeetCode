class Solution {
    public int minimumMoves(String s) {
        int n = s.length();
        int i = 0, cnt = 0;
        while (i < n) {
            if (s.charAt(i) == 'X') {
                i += 3;
                cnt++;
            } else {
                i++;
            }
        }

        return cnt;
    }
}