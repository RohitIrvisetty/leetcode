class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;

        if (n % groupSize != 0) {
            return false;
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<int[]> coolDownQueue = new LinkedList<>();
        Integer prev = null;

        for (int card: hand) {
            map.put(card, map.getOrDefault(card, 0) + 1);
        }

       

        while (!map.isEmpty() || !coolDownQueue.isEmpty()) {
            int count = 0;
            prev = null;

            while (!map.isEmpty() && count < groupSize) {
                int key = map.firstKey();
                int freq = map.get(key);

                if (prev != null && key - prev != 1) {
                    return false;
                }

                count++;
                freq--;
                map.remove(key);
                prev = key;

                if (freq > 0) {
                    coolDownQueue.offer(new int[] {key, freq});
                }
            }

            if (count < groupSize) {
                return false;
            }
            
            while (!coolDownQueue.isEmpty()) {
                int[] pair = coolDownQueue.poll();
                map.put(pair[0], pair[1]);
            }
        }
        return true;
    }
}