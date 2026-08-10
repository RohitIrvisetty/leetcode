class Solution {
    public boolean isPossible(int[] nums) {
        int n = nums.length;

        Map<Integer, Integer> need = new HashMap<>();
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num: nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for (int num: nums) {
            
            if (freq.get(num) == 0) {
                continue;
            }

            freq.put(num, freq.get(num) - 1);

            if (need.containsKey(num)) {
                need.put(num, need.get(num) - 1);

                if (need.get(num) == 0) {
                    need.remove(num);
                }

                need.put(num + 1, need.getOrDefault(num + 1, 0) + 1);

            } else if (freq.containsKey(num + 1) && freq.get(num + 1) > 0 && freq.containsKey(num + 2) && freq.get(num + 2) > 0) {
                freq.put(num + 1, freq.get(num + 1) - 1);
                freq.put(num + 2, freq.get(num + 2) - 1);

                need.put(num + 3, need.getOrDefault(num + 3, 0) + 1);
            } else {
                return false;
            }
        }
        return true;
    }
}