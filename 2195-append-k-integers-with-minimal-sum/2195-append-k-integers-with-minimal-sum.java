class Solution {
    public long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);
        long sum = 0;
        long current = 1;

        for (int num: nums) {
            
            if (num == current || num == current - 1) {
                current = (long) num + 1;
                continue;
            }
            long prev = current - 1;
            long gap = num - prev - 1;

            if (gap > 0) {
                long take = Math.min(gap, k);
                long start = current;
                long end = current + take - 1;

                System.out.println(num + " " + take + " " + start + " " + end);
                sum += (end - start + 1) * (end + start) / 2;

                k -= take;
                if (k == 0) return sum;
            }
            current = (long) num + 1;
        }

        if (k > 0) {
            long start = current;
            long end = current + k - 1;

            sum += (end - start + 1) * (end + start) / 2;
        }
        return sum;
    }
}