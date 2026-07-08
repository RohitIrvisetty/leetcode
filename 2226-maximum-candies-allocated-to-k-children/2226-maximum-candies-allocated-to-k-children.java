class Solution {
    public int maximumCandies(int[] candies, long k) {
        long n = candies.length;

        long left = 0, right = maxCandies(candies);

        while (left < right) {
            long mid = left + (right - left + 1) / 2;
            
            long children = allocateCandies(candies, k, mid);
            // System.out.println(left + " " + right);

            System.out.println(children);
            
            if (children >= k) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return (int) left;
    }

    private long maxCandies(int[] candies) {
        int n = candies.length;
        long max = Long.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (candies[i] > max) {
                max = candies[i];
            }
        }

        return max;
    }

    private long allocateCandies(int[] candies, long k, long maxCandies) {
        long children = 0;
        long n = candies.length;

        if (maxCandies == 0) {
            return 0;
        }
        for (int i = 0; i < n; i++) {
            children += ((long) candies[i] / (long) maxCandies);
        }

        return children;
    }
}