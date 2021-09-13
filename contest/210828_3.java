import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// class Solution {
//     public int minSessions(int[] tasks, int sessionTime) {
//         // how to make a session as full as possible
//         // max(tasks[i]) <= sessionTime <= 15

//         // HashMap<Integer, Integer> taskCNT = new HashMap<>();
//         // for (int i = 0; i < tasks.length; i++) {
//         //     int val = taskCNT.getOrDefault(tasks[i], 0) + 1;
//         //     taskCNT.put(tasks[i], val);
//         // }

//         Arrays.sort(tasks);
//         boolean[] isAssigned=new boolean[tasks.length];

//         int sum=0;
//         for (int i = 0; i < tasks.length; i++) {
//             sum+=tasks[i];
//             isAssigned[i]=false;
//         }

//         int cnt=1, currTime=sessionTime;
//         while (sum>0) {
//             // get current min
//             int currMin=Integer.MAX_VALUE;
//             for (int i = 0; i < tasks.length; i++) {
//                 if (!isAssigned[i]) {
//                     currMin=tasks[i];
//                     break;
//                 }
//             }
//             if (currTime<currMin) {
//                 cnt++;
//                 currTime=sessionTime;
//             }
//             for (int i = tasks.length-1; i >=0; i--) {
//                 if (!isAssigned[i]&&tasks[i]<=currTime) {
//                     System.out.println(tasks[i]);
//                     isAssigned[i]=true;
//                     currTime-=tasks[i];
//                     sum-=tasks[i];
//                     break;
//                 }
//             }
//         }

//         return cnt;
//     }
// }

class Solution {
    List<Integer> res;
    int time;

    public int minSessions(int[] tasks, int sessionTime) {
        // how to make a session as full as possible
        // max(tasks[i]) <= sessionTime <= 15
        time = sessionTime;

        Arrays.sort(tasks);
        List<Integer> taskList = new ArrayList<>();
        res = new ArrayList<>();
        // descending
        for (int i = tasks.length - 1; i >= 0; i++) {
            taskList.add(tasks[i]);
        }

        dfs(taskList, sessionTime, 1);

        // 1 <= n <= 14
        int min = 14;
        for (Integer n : res) {
            min = Math.min(min, n);
        }
        return min;
    }

    public void dfs(List<Integer> taskList, int currTime, int cnt) {
        if (taskList.isEmpty()) {
            res.add(cnt);
        }

        // if curr time < min task, get a new session
        if (currTime < taskList.get(taskList.size() - 1)) {
            cnt++;
            currTime = time;
        }

        for (int i = 0; i < taskList.size(); i++) {
            if (taskList.get(i) > currTime) {
                continue;
            } else {
                int temp = taskList.get(i);
                currTime -= taskList.get(i);
                taskList.remove(i);
                dfs(taskList, currTime, cnt);
                taskList.add(i, temp);
            }
        }

    }
}