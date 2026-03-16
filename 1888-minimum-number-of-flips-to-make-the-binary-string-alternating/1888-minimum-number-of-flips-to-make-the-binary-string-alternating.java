class Solution {
    public int minFlips(String s) {
        int result = Integer.MAX_VALUE;
        String s2 = s + s;
        int length = s.length();
        int flips0 = 0, flips1 = 0;
        char[] pattern0 = new char[2 * length];
        char[] pattern1 = new char[2 * length];

        for (int i = 0; i < 2 * length; i++) {
            pattern0[i] = (i % 2 == 0) ? '0' : '1';
            pattern1[i] = (i % 2 == 1) ? '0' : '1';
        }

        for (int i = 0; i < 2 * length; i++) {
            if (pattern0[i] != s2.charAt(i))
                flips0++;
            if (pattern1[i] != s2.charAt(i))
                flips1++;

            if (i > length - 1) {
                if (pattern0[i - length] != s2.charAt(i - length))
                    flips0--;
                if (pattern1[i - length] != s2.charAt(i - length))
                    flips1--;
            }

            if (i >= length - 1) {
                result = Math.min(result, Math.min(flips0, flips1));
            }
        }
        return result;
    }
}