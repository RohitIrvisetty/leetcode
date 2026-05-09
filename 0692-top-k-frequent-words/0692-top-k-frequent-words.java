import java.util.*;

class Solution {

    Map<String, Integer> freqMap;

    public List<String> topKFrequent(String[] words, int k) {

        // Step 1: Frequency map
        freqMap = new HashMap<>();

        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        // Step 2: Unique words list
        List<String> list = new ArrayList<>(freqMap.keySet());

        // Step 3: QuickSelect
        quickSelect(list, 0, list.size() - 1, k);

        // Step 4: Take first k elements
        List<String> result = new ArrayList<>(list.subList(0, k));

        // Step 5: Final sorting
        result.sort((a, b) -> {
            int freqCompare = freqMap.get(b) - freqMap.get(a);

            if (freqCompare == 0) {
                return a.compareTo(b);
            }

            return freqCompare;
        });

        return result;
    }

    private void quickSelect(List<String> list, int left, int right, int k) {

        if (left >= right) {
            return;
        }

        int pivotIndex = partition(list, left, right);

        int leftSize = pivotIndex - left + 1;

        if (k < leftSize) {
            quickSelect(list, left, pivotIndex - 1, k);
        } else if (k > leftSize) {
            quickSelect(list, pivotIndex + 1, right, k - leftSize);
        }
    }

    private int partition(List<String> list, int left, int right) {

        String pivot = list.get(right);

        int storeIndex = left;

        for (int i = left; i < right; i++) {

            if (compare(list.get(i), pivot) < 0) {
                Collections.swap(list, storeIndex, i);
                storeIndex++;
            }
        }

        Collections.swap(list, storeIndex, right);

        return storeIndex;
    }

    // Custom comparison:
    // Higher frequency should come first
    // Lexicographically smaller comes first if tie
    private int compare(String a, String b) {

        int freqCompare = freqMap.get(b) - freqMap.get(a);

        if (freqCompare == 0) {
            return a.compareTo(b);
        }

        return freqCompare;
    }
}