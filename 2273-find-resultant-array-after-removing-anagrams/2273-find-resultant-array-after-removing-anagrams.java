import java.util.*;

class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();
        
        String prevKey = "";
        
        for (String word : words) {
            String key = getKey(word);
            
            if (!key.equals(prevKey)) {
                result.add(word);
                prevKey = key;
            }
        }
        
        return result;
    }
    
    private String getKey(String word) {
        int[] count = new int[26];
        
        for (char c : word.toCharArray()) {
            count[c - 'a']++;
        }
        
        return Arrays.toString(count); // unique signature
    }
}