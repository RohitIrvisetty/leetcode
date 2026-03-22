class Solution {
    public String smallestGoodBase(String n) {
        long num = Long.parseLong(n);

        int maxM = (int)(Math.log(num) / Math.log(2));

        for (int m = maxM; m > 1; m--) {
            long k = (long)Math.pow(num, 1.0 / m);

            if (k <= 1) continue;

            long sum = 1;
            long curr = 1;

            for (int i = 1; i <= m; i++) {
                curr *= k;
                sum += curr;
            }

            if (sum == num) {
                return String.valueOf(k);
            }
        }

        return String.valueOf(num - 1);
    }
}