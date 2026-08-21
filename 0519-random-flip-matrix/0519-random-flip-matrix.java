class Solution {
    
    Map<Integer, Integer> map = new HashMap<>();
    private int rows, cols, rem;
    private int total;

    public Solution(int m, int n) {
        rows = m;
        cols = n;
        rem = m * n;
        total = rem;
    }
    
    public int[] flip() {
        int rand = (int) (Math.random() * rem);
        
        int eleIndex = map.getOrDefault(rand, rand);
        map.put(rand, map.getOrDefault(rem - 1, rem - 1));
        rem--;
        return new int[] {eleIndex / cols, eleIndex % cols};
    }
    
    public void reset() {
        map.clear();
        total = rows * cols;
        rem = rows * cols;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(m, n);
 * int[] param_1 = obj.flip();
 * obj.reset();
 */