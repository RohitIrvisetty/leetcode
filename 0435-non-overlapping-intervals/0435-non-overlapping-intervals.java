class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        int deletedSlots = 0;
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int[] prevSlot = intervals[0];

        for (int i = 1; i < n; i++) {
            if (intervals[i][0] < prevSlot[1]) {
                deletedSlots++;
            } else {
                prevSlot = intervals[i];
            }
        }

        return deletedSlots;
    }
}