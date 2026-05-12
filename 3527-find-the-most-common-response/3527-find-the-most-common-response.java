class Solution {
    public String findCommonResponse(List<List<String>> responses) {
        Map<String, Integer> freq = new HashMap<>();

        // Count unique responses per day
        for (List<String> day : responses) {
            Set<String> unique = new HashSet<>(day);

            for (String response : unique) {
                freq.put(response, freq.getOrDefault(response, 0) + 1);
            }
        }

        String answer = "";
        int maxFreq = 0;

        for (String response : freq.keySet()) {
            int count = freq.get(response);

            if (count > maxFreq ||
               (count == maxFreq && response.compareTo(answer) < 0)) {
                maxFreq = count;
                answer = response;
            }
        }

        return answer;
    }
}