class Solution {
    public String smallestGoodBase(String n) {
        long num = Long.parseLong(n);

        int maxM = (int) (Math.log(num) / Math.log(2));

        for (int m = maxM; m > 1; m--) {
            long k = (long) Math.pow(num, 1.0 / m);

            for (long candidate = k; candidate <= k + 1; candidate++) {
                long sum = 1, curr = 1;

                for (int i = 0; i < m; i++) {
                    curr *= candidate;
                    if (curr > num) {
                        break;
                    }

                    sum += curr;
                    if (sum > num) {
                        break;
                    }
                }

                if (sum == num) {
                    return String.valueOf(candidate);
                }
            }
        }
        return String.valueOf(num - 1);
    }
}