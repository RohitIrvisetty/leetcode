import java.util.*;

class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        Map<Integer, Long> lastDay = new HashMap<>();

        long day = 0;

        for (int task : tasks) {
            day++;  // try to complete the task today

            if (lastDay.containsKey(task)) {
                long nextAllowedDay = lastDay.get(task) + space + 1;

                if (day < nextAllowedDay) {
                    day = nextAllowedDay;
                }
            }

            lastDay.put(task, day);
        }

        return day;
    }
}