class Solution {
    private int[] array;
    private int[] original;

    public Solution(int[] nums) {
        array = nums;
        original = nums.clone();    
    }
    
    public int[] reset() {
        array = original;
        original = original.clone();
        return array;
    }
    
    public int[] shuffle() {
        int n = array.length;

        for (int i = n - 1; i >= 0; i--) {
            int random = (int) (Math.random() * (i + 1));

            swap(array, i , random);
        }
        return array;
    }

    private void swap(int[] arr, int left, int right) {
        if (left != right) {
            arr[left] = arr[left] ^ arr[right];
            arr[right] = arr[left] ^ arr[right];
            arr[left] = arr[left] ^ arr[right];
        }
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */