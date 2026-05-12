class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;

        int count1 = 0, count2 = 0;
        int prev1 = Integer.MIN_VALUE, prev2 = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (prev1 == nums[i]) {
                count1++;
                continue;
            } else if (prev2 == nums[i]) {
                count2++;
                continue;
            } else if (count1 == 0) {
                count1++;
                prev1 = nums[i];
                continue;
            } else if (count2 == 0) {
                count2++;
                prev2 = nums[i];
                continue;
            } 
            count1--;
            count2--;
            

        }

        count1 = 0;
        count2 = 0;

        for (int num : nums) {
            if (num == prev1) {
                count1++;
            } else if (num == prev2) {
                count2++;
            }
        }

        List<Integer> result = new ArrayList<>();
        System.out.println(prev1 + " " + prev2);
        if (count1 > n / 3) {
            result.add(prev1);
        }

        if (count2 > n / 3) {
            result.add(prev2);
        }

        return result;
    }
}