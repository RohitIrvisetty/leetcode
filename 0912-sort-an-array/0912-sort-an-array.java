class Solution {
    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = nums[left + i];
        }

        for (int i = 0; i < n2; i++) {
            R[i] = nums[mid + i + 1];
        }

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (L[i] < R[j]) {
                nums[k++] = L[i++];
            } else {
                nums[k++] = R[j++];
            }
        }

        while (i < n1) {
            nums[k++] = L[i++];
        }

        while (j < n2) {
            nums[k++] = R[j++];
        }

    }
    
    
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }


}