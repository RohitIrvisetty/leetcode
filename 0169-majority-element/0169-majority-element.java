class Solution {
    public int majorityElement(int[] nums) {
        int count = 0, ele = 0;
        for (int num: nums) {
            if (num == ele) {
                count += 1;
            }
            else if (count == 0) {
                count += 1;
                ele = num;
            } else {
                count -= 1;
            }
        }

        return ele;
    }
}