class Solution {
    public static int commonFactors(int a, int b) {
        int g = gcd(a, b);
        return countDivisors(g);
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private static int countDivisors(int n) {
        int count = 0;

        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                count++; // i is a divisor
                if (i != n / i) {
                    count++; // n/i is another divisor
                }
            }
        }

        return count;
    }
}