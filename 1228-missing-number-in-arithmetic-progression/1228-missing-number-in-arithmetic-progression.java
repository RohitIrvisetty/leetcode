class Solution {
    public int missingNumber(int[] arr) {
        int n = arr.length;
        int gap = (arr[n - 1] - arr[0]) / n;

        int left = 0, right = n - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            int expected = arr[0] + gap * mid;

            if (expected == arr[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return arr[0] + left * gap;
    }
}