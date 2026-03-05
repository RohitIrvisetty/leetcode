class Solution {
    public int minOperations(String s) {
        int mismatchPattern0 = 0;
        int mismatchPattern1 = 0;

        for (int i = 0; i < s.length(); i++) {
            if((i % 2) == 0) {
                if (s.charAt(i) != '0') {
                    mismatchPattern0++;
                } else {
                    mismatchPattern1++;
                }
            } else {
                if (s.charAt(i) != '1') {
                    mismatchPattern0++; 
                } else {
                    mismatchPattern1++;
                }
            }
        }

        return Math.min(mismatchPattern1, mismatchPattern0);
    }
}