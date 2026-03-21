class Solution {
    public int[] sortArray(int[] nums) {
        return heapSort(nums);
    }

    private int[] heapSort(int[] nums) {
        int heapSize = nums.length;
        for (int i = (heapSize / 2) - 1; i >= 0; i--) {
            heapify(nums, heapSize, i);
        }

        for (int i = heapSize - 1; i >= 0; i--) {
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            heapify(nums, i, 0);
        }
        return nums;
     }

     private void heapify(int[] nums, int heapSize, int idx) {
        int largest = idx;
        int leftNode = 2 * idx + 1;
        int rightNode = 2 * idx + 2;

        if (leftNode < heapSize && nums[leftNode] > nums[largest]) {
            largest = leftNode;
        } 

        if (rightNode < heapSize && nums[rightNode] > nums[largest]) {
            largest = rightNode;
        }

        if (largest != idx) {
            swap(nums, largest, idx);
            heapify(nums, heapSize, largest);
        }
     }

     private void swap(int[] nums, int i, int j) {
        if (i == j) return;
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
     }
}