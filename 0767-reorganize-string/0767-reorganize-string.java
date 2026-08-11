class Solution {
    public String reorganizeString(String s) {
        int n = s.length();
        int[] freq = new int[26];
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        Arrays.fill(freq, 0);

        for (int i = 0; i < n; i++) {
            freq[s.charAt(i) - 'a']++;
            if (freq[s.charAt(i) - 'a'] > (n + 1) / 2) {
                return "";
            }
        }

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                maxHeap.offer(new int[] {freq[i], i});
            }
        }

        StringBuilder sb = new StringBuilder();
        int[] prev = null;

        while (!maxHeap.isEmpty()) {
            int[] curr = maxHeap.poll();

            sb.append((char) (curr[1] + 'a'));
            curr[0]--;

            if (prev != null && prev[0] > 0) {
                maxHeap.offer(prev);
            }

            prev = curr;
        }
        return sb.toString();
    }
}