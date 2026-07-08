class Solution {

    public int minimizedMaximum(int n, int[] quantities) {

        int low = 1;
        int high = 0;

        // Maximum quantity
        for (int q : quantities) {
            high = Math.max(high, q);
        }

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (canDistribute(quantities, n, mid)) {
                high = mid;      // Try a smaller maximum
            } else {
                low = mid + 1;   // Need a larger maximum
            }
        }

        return low;
    }

    private boolean canDistribute(int[] quantities, int n, int maxProducts) {

        long storesNeeded = 0;

        for (int q : quantities) {
            // Ceiling(q / maxProducts)
            storesNeeded += (q + maxProducts - 1) / maxProducts;

            // Early exit if we've already exceeded available stores
            if (storesNeeded > n) {
                return false;
            }
        }

        return true;
    }
}