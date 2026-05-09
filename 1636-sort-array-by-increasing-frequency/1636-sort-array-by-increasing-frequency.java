import java.util.*;

class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();

        // Step 1: frequency count
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Step 2: create buckets (index = frequency)
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            buckets.add(new ArrayList<>());
        }

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int num = entry.getKey();
            int f = entry.getValue();
            buckets.get(f).add(num);
        }

        // Step 3: build result
        int[] res = new int[nums.length];
        int idx = 0;

        for (int f = 1; f <= nums.length; f++) {
            if (buckets.get(f).isEmpty()) continue;

            // sort values with same frequency by decreasing value
            Collections.sort(buckets.get(f), Collections.reverseOrder());

            for (int num : buckets.get(f)) {
                for (int i = 0; i < f; i++) {
                    res[idx++] = num;
                }
            }
        }

        return res;
    }
}