/*
 * @lc app=leetcode id=273 lang=java
 *
 * [273] Integer to English Words
 */

// @lc code=start

class Solution {
    StringBuilder res;

    public String numberToWords(int num) {
        if (num == 0)
            return "Zero";

        res = new StringBuilder();

        // billion
        if (num >= 1000000000) {
            // get xxx million
            int xxx = num / 1000000000;
            get1to999(xxx);
            res.append(" Billion");
            num %= 1000000000;
            if (num > 0)
                res.append(" ");
        }
        // million
        if (num >= 1000000) {
            // get xxx million
            int xxx = num / 1000000;
            get1to999(xxx);
            res.append(" Million");
            num %= 1000000;
            if (num > 0)
                res.append(" ");
        }
        // thousand
        if (num >= 1000) {
            // get xxx thousand
            int xxx = num / 1000;
            get1to999(xxx);
            res.append(" Thousand");
            num %= 1000;
            if (num > 0)
                res.append(" ");
        }
        // 1 to 999
        get1to999(num);

        return res.toString();

    }

    public void get1to999(int num) {
        if (num >= 100) {
            res.append(getNum10(num / 100));
            res.append(" Hundred");
            num %= 100;
            if (num > 0)
                res.append(" ");
        }
        if (num >= 20) {
            res.append(getNum100(num / 10));
            num %= 10;
            if (num > 0)
                res.append(" ");
        }
        if (10 <= num && num < 20) {
            res.append(getNum20(num));
        } else if (num < 10) {
            res.append(getNum10(num));
        }
    }

    public String getNum10(int num) {
        switch (num) {
            case 1:
                return "One";
            case 2:
                return "Two";
            case 3:
                return "Three";
            case 4:
                return "Four";
            case 5:
                return "Five";
            case 6:
                return "Six";
            case 7:
                return "Seven";
            case 8:
                return "Eight";
            case 9:
                return "Nine";
        }
        return "";
    }

    public String getNum20(int num) {
        switch (num) {
            case 10:
                return "Ten";
            case 11:
                return "Eleven";
            case 12:
                return "Twelve";
            case 13:
                return "Thirteen";
            case 14:
                return "Fourteen";
            case 15:
                return "Fifteen";
            case 16:
                return "Sixteen";
            case 17:
                return "Seventeen";
            case 18:
                return "Eighteen";
            case 19:
                return "Nineteen";
        }
        return "";
    }

    public String getNum100(int num) {
        switch (num) {
            case 2:
                return "Twenty";
            case 3:
                return "Thirty";
            case 4:
                return "Forty";
            case 5:
                return "Fifty";
            case 6:
                return "Sixty";
            case 7:
                return "Seventy";
            case 8:
                return "Eighty";
            case 9:
                return "Ninety";
        }
        return "";
    }
}

// @lc code=end
