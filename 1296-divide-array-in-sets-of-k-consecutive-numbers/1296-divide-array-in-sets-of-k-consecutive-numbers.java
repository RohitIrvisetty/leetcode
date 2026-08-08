class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        int n = nums.length;

        if (n % k != 0) {
            return false;
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        while(!map.isEmpty()) {
            int key = map.firstKey();

            for (int i = key; i < key + k; i++) {

                if (!map.containsKey(i)) {
                    return false;
                }

                int value = map.get(i);
                value--;
                map.remove(i);

                if (value > 0) {
                    map.put(i, value);
                }
            }
        }
        return true;
    }
}