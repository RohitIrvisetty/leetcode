class Solution {
    // Function to calculate total beauty sum
    public int beautySum(String s) {
        // Variable to store total beauty
        int totalBeauty = 0;

        // Loop over all possible starting indices
        for (int i = 0; i < s.length(); i++) {
            // Frequency array for each substring
            int[] freq = new int[26];

            // Expand substring by moving end pointer
            for (int j = i; j < s.length(); j++) {
                // Update frequency
                freq[s.charAt(j) - 'a']++;

                // Find max and min (excluding zeros)
                int maxFreq = 0, minFreq = Integer.MAX_VALUE;
                for (int f : freq) {
                    if (f > 0) {
                        maxFreq = Math.max(maxFreq, f);
                        minFreq = Math.min(minFreq, f);
                    }
                }

                // Add current substring’s beauty
                totalBeauty += maxFreq - minFreq;
            }
        }
        // Return total beauty sum
        return totalBeauty;
    }
}