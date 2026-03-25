class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = getMax(weights), right = sum(weights);

        while (left < right) {
            int mid = left + (right - left) / 2;

            int currDays = calculateDays(weights, mid);
            if (currDays <= days) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private int sum(int[] weights) {
        int sum = 0;

        for (int weight: weights) {
            sum += weight;
        }
        return sum;
    }

    private int getMax(int[] weights) {
        int max = Integer.MIN_VALUE;

        for (int weight: weights) {
            max = Math.max(weight, max);
        }
        return max;
    }

    private int calculateDays(int[] weights, int capacity) {
        int days = 0;
        int counter = 0;
        
        for (int weight: weights) {
            if (counter + weight <= capacity) {
                counter += weight;
                if (counter == capacity) {
                    counter = 0;
                    days += 1;
                }
            } else {
                counter = 0;
                days += 1;
                counter += weight;
            }
        }

        if (counter > 0) {
            days += 1;
        }
       

        return days;
    }
}