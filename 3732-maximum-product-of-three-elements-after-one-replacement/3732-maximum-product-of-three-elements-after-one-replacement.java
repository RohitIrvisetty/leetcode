class Solution {
    public long maxProduct(int[] nums) {
        final long M = 100000L;

        long max1 = Long.MIN_VALUE;
        long max2 = Long.MIN_VALUE;
        long max3 = Long.MIN_VALUE;

        long min1 = Long.MAX_VALUE;
        long min2 = Long.MAX_VALUE;

        for (int x : nums) {
            // largest 3
            if (x > max1) {
                max3 = max2;
                max2 = max1;
                max1 = x;
            } else if (x > max2) {
                max3 = max2;
                max2 = x;
            } else if (x > max3) {
                max3 = x;
            }

            // smallest 2
            if (x < min1) {
                min2 = min1;
                min1 = x;
            } else if (x < min2) {
                min2 = x;
            }
        }

        // Best absolute pair product
        long bestAbsPair = Math.max(
            Math.abs(max1 * max2),
            Math.max(
                Math.abs(min1 * min2),
                Math.abs(max1 * min1)
            )
        );

        long ans = M * bestAbsPair;

        // // Keep original best triple if replacement unused
        // if (nums.length >= 4) {
        //     long original = Math.max(
        //         max1 * max2 * max3,
        //         min1 * min2 * max1
        //     );

        //     ans = Math.max(ans, original);
        // }

        return ans;
    }
}