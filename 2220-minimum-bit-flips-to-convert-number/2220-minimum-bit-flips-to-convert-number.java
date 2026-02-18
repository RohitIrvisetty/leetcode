class Solution {
    public int minBitFlips(int start, int goal) {
        int xorResult = start ^ goal;
        int count = 0, mask = 1;
        while (xorResult > 0) {
            count = count + (xorResult & mask);
            xorResult = xorResult >> 1;
            mask = mask << 1;
        }
        return count;
    }
}