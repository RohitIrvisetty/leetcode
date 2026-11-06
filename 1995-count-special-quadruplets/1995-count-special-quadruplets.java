class Solution {
    public int countQuadruplets(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int b = n - 3; b >= 1; b--) {
            int c = b + 1;

            for (int d = b + 2; d < n; d++) {
                int diff = nums[d] - nums[c];

                map.put(diff, map.getOrDefault(diff, 0) + 1);
            }

            for (int a = 0; a < b; a++) {
                int sum = nums[a] + nums[b];

                count += map.getOrDefault(sum, 0);
            }
        }

        return count;
    }
}