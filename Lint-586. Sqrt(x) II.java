public class Solution {
    /**
     * @param x: a double
     * @return: the square root of x
     */
    public double sqrt(double x) {
        // write your code here
        // The accuracy is kept at 12 decimal places.
        double left = 0, right = x / 2;
        if (x < 1)
            right = 1;
        if (x < 4)
            right = x;

        while (left < right) {
            double mid = (left + right) / 2.;

            if (mid * mid <= x && (mid + 0.000000000001) * (mid + 0.000000000001) > x) {
                return mid;
            } else if (mid * mid < x) {
                left = mid + 0.000000000001;
            } else {
                right = mid - 0.000000000001;
            }
        }
        return left;
    }
}
