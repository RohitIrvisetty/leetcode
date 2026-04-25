import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        
        if (s.length() < p.length()) return result;

        int[] freq = new int[26];

        // Fill frequency for p
        for (char c : p.toCharArray()) {
            freq[c - 'a']++;
        }

        int left = 0, right = 0;
        int count = p.length();

        while (right < s.length()) {
            // If current char is needed, decrease count
            if (freq[s.charAt(right) - 'a']-- > 0) {
                count--;
            }
            right++;

            // When all chars matched
            if (count == 0) {
                result.add(left);
            }

            // Maintain window size = p.length()
            if (right - left == p.length()) {
                // If removing char was part of p, increase count
                if (freq[s.charAt(left) - 'a']++ >= 0) {
                    count++;
                }
                left++;
            }
        }

        return result;
    }
}