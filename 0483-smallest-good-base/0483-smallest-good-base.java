class Solution {

    public String smallestGoodBase(String n) {
        long num = Long.parseLong(n);

        // maximum exponent
        int maxM = (int) (Math.log(num) / Math.log(2));

        for (int m = maxM; m >= 1; m--) {

            long left = 2;
            long right = (long) Math.pow(num, 1.0 / m);

            while (left <= right) {

                long mid = left + (right - left) / 2;

                long sum = 1;
                long curr = 1;

                boolean overflow = false;

                for (int i = 0; i < m; i++) {

                    if (curr > num / mid) {
                        overflow = true;
                        break;
                    }

                    curr *= mid;

                    if (sum > num - curr) {
                        overflow = true;
                        break;
                    }

                    sum += curr;
                }

                if (!overflow && sum == num) {
                    return String.valueOf(mid);
                }

                if (overflow || sum > num) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        // always valid: n = 11 in base (n-1)
        return String.valueOf(num - 1);
    }
}