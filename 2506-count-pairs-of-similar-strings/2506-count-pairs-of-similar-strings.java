import java.util.*;

class Solution {
    public int similarPairs(String[] words) {
        Map<Integer, Integer> map = new HashMap<>();
        
        // Step 1: Build frequency map of bitmasks
        for (String word : words) {
            int mask = 0;
            
            for (char c : word.toCharArray()) {
                mask |= (1 << (c - 'a'));
            }
            
            map.put(mask, map.getOrDefault(mask, 0) + 1);
        }
        
        // Step 2: Count pairs
        int result = 0;
        for (int freq : map.values()) {
            result += freq * (freq - 1) / 2;
        }
        
        return result;
    }
}