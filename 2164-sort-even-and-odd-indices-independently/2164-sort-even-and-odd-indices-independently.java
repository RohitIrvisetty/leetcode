import java.util.*;

class Solution {
    public int[] sortEvenOdd(int[] nums) {
        int n = nums.length;

        int evenCount = (n + 1) / 2;
        int oddCount = n / 2;

        int[] even = new int[evenCount];
        int[] odd = new int[oddCount];

        int e = 0, o = 0;

        // Collect values
        for (int i = 0; i < n; i++) {
            if ((i & 1) == 0) {
                even[e++] = nums[i];
            } else {
                odd[o++] = nums[i];
            }
        }

        Arrays.sort(even);
        Arrays.sort(odd);

        e = 0;
        o = oddCount - 1;

        // Rebuild array
        for (int i = 0; i < n; i++) {
            if ((i & 1) == 0) {
                nums[i] = even[e++];
            } else {
                nums[i] = odd[o--]; // descending
            }
        }

        return nums;
    }
}