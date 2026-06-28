class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;

        int rightPointer = n - 1;
        int leftPointer = 1;
        int prev = nums[0], count = 1;

        while (leftPointer <= rightPointer) {
            if (nums[leftPointer] == prev) {
                count++;
            } else {
                count = 1;
                prev = nums[leftPointer];
            }

            System.out.println(nums[leftPointer] + " " + count);
            if (count > 2) {
                moveToLast(nums, leftPointer);
                count--;
                rightPointer--;
                
                if (nums[leftPointer] != prev) {
                    count = 1;
                    prev = nums[leftPointer];
                } else {
                    continue;
                }
            }

            leftPointer++;
        }
        return rightPointer + 1;
    }

    private void moveToLast(int[] nums, int index) {
        int n = nums.length;

        for (int i = index; i < n - 1; i++) {
            swap(nums, i, i + 1);
        }
    }

    private void swap(int[] nums, int left, int right) {
        if (left != right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
    }
}