/*
 * @lc app=leetcode id=362 lang=java
 *
 * [362] Design Hit Counter
 */

// @lc code=start
class HitCounter {
    // <timestamp, hits>
    class Second {
        int timestamp;
        int hits;

        public Second(int timestamp, int hits) {
            this.timestamp = timestamp;
            this.hits = hits;
        }
    }

    List<Second> secList;

    public HitCounter() {
        secList = new ArrayList<>();
    }

    public void hit(int timestamp) {
        // 1. try to find it in the list
        if (!secList.isEmpty() && secList.get(secList.size() - 1).timestamp == timestamp)
            secList.get(secList.size() - 1).hits++;
        // 2. add new Second
        else
            secList.add(new Second(timestamp, 1));
    }

    public int getHits(int timestamp) {
        int sum = 0, left = Math.max(1, timestamp - 299);
        for (Second sec : secList) {
            if (sec.timestamp > timestamp)
                break;
            else if (left <= sec.timestamp) {
                sum += sec.hits;
            }
        }

        return sum;
    }
}
/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
// @lc code=end
