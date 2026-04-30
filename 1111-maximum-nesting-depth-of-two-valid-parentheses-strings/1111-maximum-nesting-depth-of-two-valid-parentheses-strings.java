class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int[] result = new int[n];
        int aOpen = 0, bOpen = 0;

        for (int i = 0; i < n; i++) {
            char ch = seq.charAt(i);

            if (ch == '(') {
                if (aOpen <= bOpen) {
                    aOpen++;
                    result[i] = 0;
                } else {
                    bOpen++;
                    result[i] = 1;
                }
            } else {
                if (aOpen >= bOpen) {
                    aOpen--;
                    result[i] = 0;
                } else {
                    bOpen--;
                    result[i] = 1;
                }
            }
        }

        return result;
    }
}