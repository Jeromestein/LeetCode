import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode id=1396 lang=java
 *
 * [1396] Design Underground System
 */

// @lc code=start

class UndergroundSystem {
    class Start {
        String station;
        int time;

        public Start(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    class StartEnd {
        String start;
        String end;

        public StartEnd(String start, String end) {
            this.start = start;
            this.end = end;
        }

        public int hashCode() {
            return (start + end).hashCode();
        }

        public boolean equals(Object obj2) {
            if (obj2 instanceof StartEnd) {
                StartEnd startEnd2 = (StartEnd) obj2;
                return this.start.equals(startEnd2.start) && this.end.equals(startEnd2.end);
            }
            return false;
        }
    }

    class TimePeople {
        int totalTime;
        int totalPeople;

        public TimePeople(int totalTime, int amount) {
            this.totalTime = totalTime;
            this.totalPeople = amount;
        }
    }

    Map<Integer, Start> startInfo;
    Map<StartEnd, TimePeople> travalInfo;

    public UndergroundSystem() {
        startInfo = new HashMap<Integer, Start>();
        travalInfo = new HashMap<StartEnd, TimePeople>();
    }

    public void checkIn(int id, String stationName, int t) {
        startInfo.put(id, new Start(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Start start = startInfo.get(id);
        // A customer can only be checked into one place at a time.
        String startStation = start.station;
        int startTime = start.time;

        StartEnd startEnd = new StartEnd(startStation, stationName);
        TimePeople sumAmount = travalInfo.getOrDefault(startEnd, new TimePeople(0, 0));
        sumAmount.totalTime += t - startTime;
        sumAmount.totalPeople++;

        travalInfo.put(startEnd, sumAmount);
    }

    public double getAverageTime(String startStation, String endStation) {
        StartEnd travel = new StartEnd(startStation, endStation);
        TimePeople sumAmount = travalInfo.get(travel);

        int sum = sumAmount.totalTime, amount = sumAmount.totalPeople;

        return 1.0 * sum / amount;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t); obj.checkOut(id,stationName,t); double param_3
 * = obj.getAverageTime(startStation,endStation);
 */
// @lc code=end
