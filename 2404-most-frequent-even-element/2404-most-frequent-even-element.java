import java.util.*;

class Solution {
    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            if (num % 2 == 0) {
                freq.put(num, freq.getOrDefault(num, 0) + 1);
            }
        }

        int ans = -1;
        int maxFreq = 0;

        for (int num : freq.keySet()) {
            int count = freq.get(num);

            if (count > maxFreq ||
               (count == maxFreq && num < ans)) {

                maxFreq = count;
                ans = num;
            }
        }

        return ans;
    }
}