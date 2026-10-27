class Solution {

    public int minimumPairRemoval(int[] nums) {
        var n = nums.length;
        var next = new int[n];
        Arrays.setAll(next, i -> i + 1);
        next[n - 1] = -1;
        for (int i = 0; i < n; i++) {
            System.out.println(next[i]);
        }
        var count = 0;

        while (n-- > 1) {
            var curr = 0;
            var target = 0;
            var targetAdjSum = nums[target] + nums[next[target]];
            var isAscending = true;

            while (next[curr] != -1) {
                if (nums[curr] > nums[next[curr]]) {
                    isAscending = false;
                }

                var currAdjSum = nums[curr] + nums[next[curr]];
                if (currAdjSum < targetAdjSum) {
                    target = curr;
                    targetAdjSum = currAdjSum;
                }
                curr = next[curr];
            }

            if (isAscending) {
                break;
            }

            count++;
            next[target] = next[next[target]];
            nums[target] = targetAdjSum;
        }

        return count;
    }
}