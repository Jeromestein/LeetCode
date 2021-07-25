class Solution {
    public String maximumNumber(String num, int[] change) {
        char[] numChar = num.toCharArray();

        boolean preChanged = false, firstChanged = false;
        for (int i = 0; i < num.length(); i++) {
            char c = numChar[i];
            char cChange = (char) (change[c - '0'] + '0');
            // not change yet or pre digit is changed
            if (!firstChanged || preChanged) {
                if (cChange > c) {
                    numChar[i] = cChange;
                    firstChanged = true;
                    preChanged = true;
                } else if (cChange < c) {
                    // if cChange== c, then it could be considered as change or not change...
                    preChanged = false;
                }
            }
        }

        return String.valueOf(numChar);
    }
}
