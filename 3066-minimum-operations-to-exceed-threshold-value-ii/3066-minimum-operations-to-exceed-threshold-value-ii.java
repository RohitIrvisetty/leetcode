class Solution {
    public int minOperations(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();

        pq.addAll(
        Arrays.stream(nums)
            .mapToLong(i -> i)
            .boxed()
            .toList()
        );

        while (pq.peek() < k && pq.size() >= 2) {
            Long min1 = pq.poll();
            Long min2 = pq.poll();

            pq.add(2 * min1 + min2);
            count++;
        }

        return count;
    }
}