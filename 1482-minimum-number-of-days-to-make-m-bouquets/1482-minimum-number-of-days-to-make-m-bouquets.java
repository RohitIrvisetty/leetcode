class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if (m > n / k) {
            return - 1;
        }

        int left = getMin(bloomDay), right = getMax(bloomDay);
        while (left < right) {
            int mid = left + (right - left) / 2;
            int bouquets = makeBouquets(bloomDay, mid, k);
            
            
            if (bouquets >= m) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private int getMin(int[] bloomDay) {
        int min = Integer.MAX_VALUE;
        for (int day: bloomDay) {
            min = Math.min(min, day);
        }
        
        return min;
    }

    private int getMax(int[] bloomDay) {
        int max = Integer.MIN_VALUE;
        for (int day: bloomDay) {
            max = Math.max(max, day);
        }
        return max;
    }

    private int makeBouquets(int[] bloomDay, int day, int adjFlowersReq) {

        int counter = 0;
        int adjFlowersCount = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= day) {
                counter++;
                if (counter == adjFlowersReq) {
                    adjFlowersCount += (counter / adjFlowersReq);
                    counter = 0;
                }
            } else {
                counter = 0;
            }
        }
        return adjFlowersCount;
    } 
}