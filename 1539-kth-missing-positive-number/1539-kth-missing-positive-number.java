class Solution {
    public int findKthPositive(int[] arr, int k) {
        int current = 1, n = arr.length;

        for (int i = 0; i < n; i++) {
            if (current == arr[i]) {
                current++;
                continue;
            }

            if ((k - arr[i] + current) <= 0) {
                break;
            }

            k -= arr[i] - current;
            current = arr[i] + 1;
        }

        
        while (k > 0) {
            k--;
            current++;
        }
        return current - 1;
    }
}