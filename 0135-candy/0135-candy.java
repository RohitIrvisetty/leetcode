class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;

        int total = 1;
        int up = 1;
        int down = 1;
        int peak = 0;

        for (int i = 1; i < n; i++) {

            // Increasing slope
            if (ratings[i] > ratings[i - 1]) {
                up++;
                peak = up;
                down = 1;

                total += up;
            }

            // Equal ratings
            else if (ratings[i] == ratings[i - 1]) {
                up = 1;
                down = 1;
                peak = 1;

                total += 1;
            }

            // Decreasing slope
            else {
                down++;
                up = 1;

                total += down;

                // Peak was already counted.
                // If peak is large enough, remove the extra candy
                // that the decreasing sequence assigned to it.
                if (peak >= down) {
                    total--;
                }
            }
        }

        return total;
    }
}