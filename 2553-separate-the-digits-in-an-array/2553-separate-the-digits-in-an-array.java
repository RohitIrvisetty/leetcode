class Solution {
    public int[] separateDigits(int[] nums) {
        int n = nums.length;
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            answer.addAll(getDigits(nums[i]));
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

    private List<Integer> getDigits(int num) {
        List<Integer> digits = new ArrayList<>();

        while (num > 0) {
            int digit = num % 10;
            num = num / 10;
            digits.add(digit);
        }

        return digits.reversed();
    }
}