/*
 * @lc app=leetcode id=1603 lang=java
 *
 * [1603] Design Parking System
 */

// @lc code=start
class ParkingSystem {
    int[] limits = new int[3];
    int[] curr = new int[3];

    public ParkingSystem(int big, int medium, int small) {
        limits[0] = big;
        limits[1] = medium;
        limits[2] = small;
        curr[0] = 0;
        curr[1] = 0;
        curr[2] = 0;
    }

    public boolean addCar(int carType) {
        if (curr[carType - 1] < limits[carType - 1]) {
            curr[carType - 1]++;
            return true;
        } else {
            return false;
        }
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
// @lc code=end
