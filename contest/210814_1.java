class Solution {
    public int findGCD(int[] nums) {
        int min=2147483647, max=0;
        // get min and max
        for (int i=0; i<nums.length;i++){
            min=Math.min(min, nums[i]);
            max=Math.max(max, nums[i]);
        }
        
        return getGCD(min, max);
    }
    
    public static int getGCD(int m, int n) {
        int result = 0;
        while (n != 0) {
            result = m % n;
            m = n;
            n = result;
        }
        return m;
    }

}
