class Solution {
    public int minGroups(int[][] intervals) {
        int n = intervals.length;

        int[] start = new int[n];
        int[] end = new int[n];

        for (int i = 0; i < n; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);
        
        int s_ptr = 0, e_ptr = 0;
        int rooms = 0;

        while (s_ptr < n) {
            if (start[s_ptr] > end[e_ptr]) {
                rooms -= 1;
                e_ptr += 1;
            }

            rooms += 1;
            s_ptr += 1;
        }
        return rooms;
    }
}