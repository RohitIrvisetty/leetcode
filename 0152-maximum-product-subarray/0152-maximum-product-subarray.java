class Solution {
    private int[] swap(int num1, int num2) {
        return new int[] {num2, num1};
    }
    public int maxProduct(int[] nums) {
        int maxProd = nums[0];
        int minProd = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int[] swapped = swap(maxProd, minProd);
                maxProd = swapped[0];
                minProd = swapped[1];
            }

            maxProd = Math.max(nums[i], nums[i] * maxProd);
            minProd = Math.min(nums[i], nums[i] * minProd);

            result = Math.max(result, maxProd);
        }    
        return result;
    }
}