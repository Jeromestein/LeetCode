class Solution {

    public int maxConsecutiveAnswers(String answerKey, int k) {
        char[] keys = answerKey.toCharArray();
        int max = 0;

        int left = 0, right, tempK = k;
        for (right = 0; right < keys.length; right++) {
            // If we included a T in the window we reduce the value of k.
            // Since k is the maximum Ts allowed in a window.
            if (keys[right] == 'T') {
                tempK--;
            }
            // A negative k denotes we have consumed all allowed flips and window has
            // more than allowed zeros, thus increment left pointer by 1 to keep the window
            // size same.
            if (tempK < 0) {
                // If the left element to be thrown out is T we increase k.
                if (keys[left] == 'T')
                    tempK += 1;
                left++;
            }
        }
        max = right - left;
        System.out.println(left + " " + right);

        left = 0;
        tempK = k;
        for (right = 0; right < keys.length; right++) {
            // If we included a F in the window we reduce the value of k.
            // Since k is the maximum Ts allowed in a window.
            if (keys[right] == 'F') {
                tempK--;
            }
            // A negative k denotes we have consumed all allowed flips and window has
            // more than allowed zeros, thus increment left pointer by 1 to keep the window
            // size same.
            if (tempK < 0) {
                // If the left element to be thrown out is F we increase k.
                if (keys[left] == 'F')
                    tempK += 1;
                left++;
            }
        }
        max = Math.max(max, right - left);
        System.out.println(left + " " + right);
        return max;
    }
}