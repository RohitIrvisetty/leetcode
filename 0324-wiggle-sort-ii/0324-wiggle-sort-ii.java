class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        int[] res = new int[n];

        int left = (n - 1) / 2;  // end of small half
        int right = n - 1;       // end of large half

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                res[i] = nums[left--];
            } else {
                res[i] = nums[right--];
            }
        }

        // copy back
        System.arraycopy(res, 0, nums, 0, n);
    }
}