import java.util.*;

class Solution {

    public int[] topKFrequent(int[] nums, int k) {

        // Step 1: Frequency map
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Step 2: Convert map to list
        List<int[]> arr = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            arr.add(new int[]{entry.getKey(), entry.getValue()});
            // [number, frequency]
        }

        // Step 3: QuickSelect
        quickSelect(arr, 0, arr.size() - 1, k);

        // Step 4: Collect top k elements
        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = arr.get(i)[0];
        }

        return result;
    }

    private void quickSelect(List<int[]> arr, int left, int right, int k) {

        if (left >= right) {
            return;
        }

        int pivotIndex = partition(arr, left, right);

        if (pivotIndex == k - 1) {
            return;
        }
        else if (pivotIndex < k - 1) {
            quickSelect(arr, pivotIndex + 1, right, k);
        }
        else {
            quickSelect(arr, left, pivotIndex - 1, k);
        }
    }

    private int partition(List<int[]> arr, int left, int right) {

        // Random pivot
        int pivotIndex = left + new Random().nextInt(right - left + 1);

        swap(arr, pivotIndex, right);

        int pivotFreq = arr.get(right)[1];

        int store = left;

        // Higher frequencies go left
        for (int i = left; i < right; i++) {

            if (arr.get(i)[1] > pivotFreq) {

                swap(arr, store, i);
                store++;
            }
        }

        swap(arr, store, right);

        return store;
    }

    private void swap(List<int[]> arr, int i, int j) {

        int[] temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }
}