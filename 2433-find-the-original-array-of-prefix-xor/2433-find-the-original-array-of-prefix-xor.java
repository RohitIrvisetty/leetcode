class Solution {
    public int[] findArray(int[] pref) {
        int prefix = 0;

        for (int i = 0; i < pref.length; i++) {
            pref[i] = prefix ^ pref[i];
            prefix = prefix ^ pref[i];
        }

        return pref;
    }
}