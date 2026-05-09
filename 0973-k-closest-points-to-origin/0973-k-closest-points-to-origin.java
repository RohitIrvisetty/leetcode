class Solution {
    private Random random = new Random();

    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        int target = k - 1;

        int left = 0, right = n - 1;

        while (left <= right) {
            int pivot = partition(points, left, right);

            if (pivot == target) {
                break;
            } else if(pivot < target) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }

        int[][] kClosestPoints = new int[k][];

        for (int i = 0; i < k; i++) {
            kClosestPoints[i] = points[i];
        }
        return kClosestPoints;
    }

    private int partition(int[][] points, int left, int right) {
        int randomIndex = left + random.nextInt(right - left + 1);
        swap(points, right, randomIndex);

        int[] pivot = points[right];
        int divider = left;

        for (int i = left; i < right; i++) {
            if (compareEuclidDistance(points[i], pivot) < 0) {
                swap(points, divider, i);
                divider++;
            }
        }
        swap(points, divider, right);
        return divider;
    }

    private double compareEuclidDistance(int[] pointA, int[] pointB) {
        return euclideanDistance(pointA) - euclideanDistance(pointB);
    }

    private double euclideanDistance(int[] point) {

        return Math.sqrt(point[0] * point[0] + point[1] * point[1]);
    }

    private void swap(int[][] points, int left, int right) {
        if (left == right) return;

        int[] temp = points[left];
        points[left] = points[right];
        points[right] = temp;
    }
}