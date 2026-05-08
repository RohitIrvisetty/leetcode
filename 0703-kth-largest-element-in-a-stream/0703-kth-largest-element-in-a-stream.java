import java.util.PriorityQueue;

class KthLargest {

    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();

        for (int num : nums) {
            this.add(num);
        }
    }

    public int add(int val) {
        minHeap.add(val);

        // Keep only k largest elements
        if (minHeap.size() > k) {
            minHeap.poll();
        }

        // Root = kth largest
        return minHeap.peek();
    }
}