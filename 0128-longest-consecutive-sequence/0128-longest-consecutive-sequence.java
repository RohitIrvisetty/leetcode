class Solution {
    public int longestConsecutive(int[] nums) {
        int maxlen = 0;
        Set<Integer> numSet = new HashSet<>();

        for (int num : nums) {
            numSet.add(num);
        }

        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int length = 1;

                while (numSet.contains(currentNum + 1)) {
                    currentNum = currentNum + 1;
                    length += 1;
                }

                maxlen = Math.max(maxlen, length);
            }
        }

        return maxlen;
    }
}