class Solution {
    public int maxArea(int[] height) {
        int maxWater = 0;
        int left = 0;
        int right = height.length - 1;
        
        while (left < right) {
            int length = Math.min(height[right], height[left]);
            int breadth = right - left;
            int area = length * breadth;

            maxWater = Math.max(maxWater, area);

            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxWater;
    }
}