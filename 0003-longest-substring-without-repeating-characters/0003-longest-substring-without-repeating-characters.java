class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0;
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) >= left) {
                left = map.get(s.charAt(i)) + 1;
            }

            map.put(s.charAt(i), i);

            maxLen = Math.max(maxLen, i - left + 1);
        }
        return maxLen;
    }
}