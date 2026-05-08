class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int index = -1;
        int minManhattanDist = Integer.MAX_VALUE;
        int[] givenPoint = {x, y};

        for (int i = 0; i < points.length; i++) {
            if (points[i][0] == x || points[i][1] == y) {
                int currentManhattanDistance = manhattanDistance(points[i], givenPoint);
                if (currentManhattanDistance < minManhattanDist) {
                    minManhattanDist = currentManhattanDistance;
                    index = i;
                }
            }
        }
        return index;
    }

    private int manhattanDistance(int[] point1, int[] point2) {
        return Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
    }
}