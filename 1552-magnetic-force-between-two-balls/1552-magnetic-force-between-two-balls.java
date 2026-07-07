class Solution {
    public int maxDistance(int[] position, int m) {
        int n = position.length;
        Arrays.sort(position);

        int left = 1, right = position[n - 1] - position[0];

        while (left < right) {
            int mid = left + (right - left + 1) / 2;

            if (canWePlace(position, mid, m)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private boolean canWePlace(int[] position, int currDist, int totalBalls) {
        int n = position.length;
        int lastPlacedBall = position[0];
        int placedBalls = 1;

        for (int i = 1; i < n; i++) {
            if (position[i] - lastPlacedBall >= currDist) {
                placedBalls++;
                lastPlacedBall = position[i];

                if (placedBalls == totalBalls) {
                    return true;
                }
            }
        } 
        return false;
    }
}