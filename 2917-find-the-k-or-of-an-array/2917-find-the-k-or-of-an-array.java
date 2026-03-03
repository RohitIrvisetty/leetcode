class Solution {
    public int findKOr(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if ((nums[j] & (1 << i)) != 0) {
                    count++;
                    if (count >= k) {
                        ans |= (1 << i);
                        break;
                    }
                }
            }

            
        }
        return ans;
    }
}