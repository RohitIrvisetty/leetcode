
import java.util.*;

class Solution {

    private int[][] rects;
    private int[] prefix;
    private int total;
    private Random random;

    public Solution(int[][] rects) {
        this.rects = rects;
        this.prefix = new int[rects.length];
        this.random = new Random();

        for (int i = 0; i < rects.length; i++) {
            int[] rect = rects[i];

            int width = rect[2] - rect[0] + 1;
            int height = rect[3] - rect[1] + 1;

            total += width * height;
            prefix[i] = total;
        }
    }

    public int[] pick() {

        int target = random.nextInt(total);

        // Find rectangle using binary search
        int left = 0;
        int right = prefix.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (prefix[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        int[] rect = rects[left];

        int x = rect[0] +
                random.nextInt(rect[2] - rect[0] + 1);

        int y = rect[1] +
                random.nextInt(rect[3] - rect[1] + 1);

        return new int[]{x, y};
    }
}
