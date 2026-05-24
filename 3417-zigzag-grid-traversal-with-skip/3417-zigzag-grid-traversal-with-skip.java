class Solution {
    public List<Integer> zigzagTraversal(int[][] grid) {
        int[][] directions = {{0, 2}, {0, -2}};
        int currentDirection = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[] currIdx = {0, 0};
        List<Integer> result = new ArrayList<>();
        
        while (currIdx[0] < m) {
            
            result.add(grid[currIdx[0]][currIdx[1]]);
            currIdx[1] = currIdx[1] + directions[currentDirection][1];

            if (currIdx[1] > n - 1 || currIdx[1] < 0) {
                currentDirection = (currentDirection + 1) % 2;
                
                currIdx[0]++;
                if (currIdx[0] >= m) {
                    break;
                }

                if (currIdx[1] > n - 1) {
                    if (currIdx[1] == n) {
                        currIdx[1] = n - 1;
                    } else {
                        currIdx[1] = n - 2;
                    }
                } else if (currIdx[1] < 0) {
                    if (currIdx[1] == -1) {
                        currIdx[1] = 0;
                    } else {
                        currIdx[1] = 1;
                    }
                }
            }

        }

        return result;
    }
}