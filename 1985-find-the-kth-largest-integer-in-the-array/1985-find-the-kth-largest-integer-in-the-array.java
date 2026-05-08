import java.util.*;

class Solution {

    public String kthLargestNumber(String[] nums, int k) {
        int target = nums.length - k;

        quickSelect(nums, 0, nums.length - 1, target);

        return nums[target];
    }

    private void quickSelect(String[] nums, int left, int right, int k) {

        while (left <= right) {

            int pivotIndex = partition(nums, left, right);

            if (pivotIndex == k) {
                return;
            } else if (pivotIndex < k) {
                left = pivotIndex + 1;
            } else {
                right = pivotIndex - 1;
            }
        }
    }

    private int partition(String[] nums, int left, int right) {

        // Random pivot
        int randomIndex = left + new Random().nextInt(right - left + 1);

        swap(nums, randomIndex, right);

        String pivot = nums[right];

        int store = left;

        for (int i = left; i < right; i++) {

            if (compare(nums[i], pivot) < 0) {
                swap(nums, store, i);
                store++;
            }
        }

        swap(nums, store, right);

        return store;
    }

    private int compare(String a, String b) {

        if (a.length() != b.length()) {
            return a.length() - b.length();
        }

        return a.compareTo(b);
    }

    private void swap(String[] nums, int i, int j) {
        String temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}