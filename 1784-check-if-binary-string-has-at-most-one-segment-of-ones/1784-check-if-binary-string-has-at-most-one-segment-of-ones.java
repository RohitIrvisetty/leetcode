class Solution {
    public boolean checkOnesSegment(String s) {
        int seenOne = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                seenOne = 1;
            } else {
                if(seenOne == 1) {
                    return false;
                }
            }
        }
        return true;
    }
}