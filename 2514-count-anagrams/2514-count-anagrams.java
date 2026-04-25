class Solution {
    static final int MOD = 1_000_000_007;

    public int countAnagrams(String s) {
        String[] words = s.split(" ");
        long result = 1;

        for (String word : words) {
            result = (result * count(word)) % MOD;
        }

        return (int) result;
    }

    private long count(String word) {
        int n = word.length();

        // Compute n!
        long numerator = 1;
        for (int i = 1; i <= n; i++) {
            numerator = (numerator * i) % MOD;
        }

        // Frequency count
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }

        // Compute denominator = product of freq!
        long denominator = 1;
        for (int f : freq) {
            if (f > 1) {
                long fact = 1;
                for (int i = 1; i <= f; i++) {
                    fact = (fact * i) % MOD;
                }
                denominator = (denominator * fact) % MOD;
            }
        }

        // numerator / denominator using modular inverse
        return (numerator * modInverse(denominator)) % MOD;
    }

    private long modInverse(long x) {
        return power(x, MOD - 2);
    }

    private long power(long base, int exp) {
        long result = 1;
        //base %= MOD;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            exp >>= 1;
        }

        return result;
    }
}