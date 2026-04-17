class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(nums, i, nums.length);
        }

        for (int i = 0; i < nums.length; i++) {
            swap(nums, 0, nums.length - i - 1);
            heapify(nums, 0, nums.length - i - 1);
        }
        
        return nums;
    }

    private void heapify(int[] nums, int index, int length) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        int largest = index;

        if (left < length && nums[left] > nums[largest]) {
            largest = left;
        }

        if (right < length && nums[right] > nums[largest]) {
            largest = right;
        }

        if (largest != index) {
            swap(nums, largest, index);
            heapify(nums, largest, length);
        }
    }

    private void swap(int[] nums, int left, int right) {
        if (left == right) return;

        nums[left] = nums[left] ^ nums[right];
        nums[right] = nums[left] ^ nums[right];
        nums[left] = nums[left] ^ nums[right];
    }
}