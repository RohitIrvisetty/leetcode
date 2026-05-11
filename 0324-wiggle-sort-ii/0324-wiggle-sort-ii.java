import java.util.*;

class Solution {

    public void wiggleSort(int[] nums) {
        int n = nums.length;

        int median = findKthLargest(nums, (n) / 2);

        int left = 0, mid = 0, right = n - 1;
        
        System.out.println(median + " " + Arrays.toString(nums));
        
        while (mid <= right) {
            System.out.println(nums[newIndex(mid, n)]);
            if (nums[newIndex(mid, n)] > median) {
                //System.out.println(nums[newIndex(mid, n)]);
                swap(nums,
                     newIndex(left, n),
                     newIndex(mid, n));
                mid++;
                left++;
            } else if (nums[newIndex(mid, n)] == median) {
                mid++;                
            } else {
                swap(nums,
                     newIndex(right, n),
                     newIndex(mid, n));
                right--;
            }
        }
    }

    private int newIndex(int index, int n) {
        return (1 + 2 * index) % (n | 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // QuickSelect for kth largest
    private int findKthLargest(int[] nums, int k) {
        int target = nums.length - k - 1;

        int left = 0, right = nums.length - 1;

        while (true) {
            int pivot = partition(nums, left, right);

            if (pivot == target)
                return nums[pivot];
            else if (pivot < target)
                left = pivot + 1;
            else
                right = pivot - 1;
        }
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int p = left;

        for (int i = left; i < right; i++) {
            if (nums[i] <= pivot) {
                swap(nums, i, p++);
            }
        }

        swap(nums, p, right);
        return p;
    }
}