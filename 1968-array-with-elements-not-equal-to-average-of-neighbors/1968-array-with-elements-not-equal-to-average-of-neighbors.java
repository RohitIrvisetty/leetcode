import java.util.*;

class Solution {    
    private Random random = new Random();

    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;

        int median = quickSelect(nums.clone(), n / 2);

        int left = 0;
        int i = 0;
        int right = n - 1;

        while (i <= right) {
            int mapped = virtualIndex(i, n);

            if (nums[mapped] < median) {
                swap(nums, virtualIndex(left++, n), mapped);
                i++;
            } else if (nums[mapped] > median) {
                swap(nums, virtualIndex(right--, n), mapped);
            } else {
                i++;
            }
        }

        return nums;
    }

    private int virtualIndex(int i, int n) {
        return (1 + 2 * i) % (n | 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // QuickSelect
    private int quickSelect(int[] nums, int k) {
        int left = 0, right = nums.length - 1;

        while (true) {
            int pivot = partition(nums, left, right);

            if (pivot == k)
                return nums[pivot];
            else if (pivot < k)
                left = pivot + 1;
            else
                right = pivot - 1;
        }
    }

    private int partition(int[] nums, int left, int right) {
        int randomIndex = left + random.nextInt(right - left + 1);
        swap(nums, randomIndex, right);
        int pivot = nums[right];
        int p = left;

        for (int i = left; i < right; i++) {
            if (nums[i] < pivot) {
                swap(nums, i, p++);
            }
        }

        swap(nums, p, right);
        return p;
    }
}