class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;
        int maxPowerOfThree = (int) (Math.log(Integer.MAX_VALUE) / Math.log(3));
        return (Math.pow(3, maxPowerOfThree) % n) == 0;
    }
}