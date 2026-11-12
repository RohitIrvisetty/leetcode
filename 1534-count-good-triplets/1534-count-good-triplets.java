class Solution {

    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int ans = 0, n = arr.length;
        int[] prefix_count = new int[1001];
        for (int j = 0; j < n; ++j) {
            for (int k = j + 1; k < n; ++k) {
                if (Math.abs(arr[j] - arr[k]) <= b) {
                    int lj = arr[j] - a, rj = arr[j] + a;
                    int lk = arr[k] - c, rk = arr[k] + c;
                    int l = Math.max(0, Math.max(lj, lk)), r = Math.min(
                        1000,
                        Math.min(rj, rk)
                    );
                    if (l <= r) {
                        if (l == 0) {
                            System.out.println(j + " " + k);
                            System.out.println(r + " " + prefix_count[r]);
                            System.out.println(l + " " + prefix_count[l]);
                            System.out.println("end of iteration");
                            ans += prefix_count[r] - 0;
                        } else {
                            System.out.println(j + " " + k);
                            System.out.println(r + " " + prefix_count[r]);
                            System.out.println(l + " " + prefix_count[l - 1]);
                            ans += prefix_count[r] - prefix_count[l - 1];
                        }
                    }
                }
            }
            for (int k = arr[j]; k <= 1000; k++) {
                //sum[x] stores the number of previously processed elements whose values are less than or equal to x.
                //                 Why is this useful?
                // Suppose we want to know how many processed elements lie between 3 and 5, inclusive.

                // We simply calculate:
                // sum[5] - sum[2]
                prefix_count[k]++;
            }
        }
        return ans;
    }
}